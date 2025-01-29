package ru.vasilev.usermanagement.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import ru.vasilev.usermanagement.model.Person;
import ru.vasilev.usermanagement.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	private UserService userService;
	private PasswordEncoder passwordEncoder;
	
	public UserController(UserService userService, PasswordEncoder passwordEncoder) {
		this.userService = userService;
		this.passwordEncoder = passwordEncoder;
	}

	@GetMapping
	public List<Person> getAllUsers(){
		return userService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getUserById(@PathVariable Integer id, Principal principal){
		String currentUsername = principal.getName();
		
		Optional<Person> user = userService.findUserById(id);
		if(user.isPresent()) {
			if(user.get().getUsername().equals(currentUsername) || hasRole("ADMIN")) {
				return ResponseEntity.ok(user.get());
			}
		}
		
		return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
	}

	@PostMapping("/register")
	public ResponseEntity<?> createUser(@Valid @RequestBody Person user) {
		String username = user.getUsername();
		if(userService.findByUsername(username).isPresent()) {
			return ResponseEntity.badRequest().body("Пользователь с таким именем уже существует");
		}
		
		user.setPassword(hashPassword(user.getPassword()));
		
		if(user.getRole() == null || user.getRole().isBlank()) {
			user.setRole("USER");
		}
		
		return ResponseEntity.status(201).body(userService.save(user));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Person> updateUser(@PathVariable Integer id, @Valid @RequestBody Person user){
		Optional<Person> foundUser = userService.findUserById(id);
		return foundUser.map(target -> {
			target.setUsername(user.getUsername());
			target.setPassword(hashPassword(user.getPassword()));
			target.setRole(user.getRole());
			return ResponseEntity.ok(userService.save(target));
		})
				.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Integer id, Principal principal){
		String currentUsername = principal.getName();
		
		Optional<Person> user = userService.findUserById(id);
		
		if(user.isPresent()) {
			if(user.get().getUsername().equals(currentUsername) || hasRole("ADMIN")) {
				userService.deleteUserById(id);
				return ResponseEntity.noContent().build();
			}
			else {
				return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
			}
		}
		return ResponseEntity.notFound().build();
	}
	
	@ExceptionHandler
	public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex){
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error ->
			errors.put(error.getField(), error.getDefaultMessage())
				);
		
		return ResponseEntity.badRequest().body(errors);
	}
	
	private String hashPassword(String password) {
		return passwordEncoder.encode(password);
	}
	
	private boolean hasRole(String role) {
		return SecurityContextHolder.getContext().getAuthentication()
				.getAuthorities().stream()
				.anyMatch(auth -> auth.getAuthority().equals(role));
	}
}