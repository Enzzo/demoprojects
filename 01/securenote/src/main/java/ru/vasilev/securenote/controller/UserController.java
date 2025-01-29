package ru.vasilev.securenote.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ru.vasilev.securenote.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {
	private final UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<String> registerUser(
			@RequestParam("username") String username,
			@RequestParam("password") String password){
		
		userService.registerUser(username, password);
		return ResponseEntity.ok("User registered successfully!");
	}
}