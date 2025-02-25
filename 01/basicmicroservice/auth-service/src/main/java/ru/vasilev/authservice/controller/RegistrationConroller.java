package ru.vasilev.authservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import ru.vasilev.authservice.model.User;
import ru.vasilev.authservice.service.UserService;

@Controller
public class RegistrationConroller {
	private final UserService userService;

	public RegistrationConroller(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/registration")
	public String showRegistrationForm(Model model) {
		model.addAttribute("userForm", new User());
		return "registration";
	}
	
	@PostMapping("/registration")
	public String registerUser(@ModelAttribute("userForm") @Valid User user, 
			BindingResult bindingResult,
			Model model) {
		if(bindingResult.hasErrors()) {
			return "registration";
		}
		if(!user.getPassword().equals(user.getPasswordConfirm())) {
			model.addAttribute("error", "Пароли не совпадают");
			return "registration";
		}
		if(userService.findByUsername(user.getUsername())!= null) {
			model.addAttribute("error", "Пользователь с таким именем уже существует");
			return "registration";
		}
		userService.save(user);
		return "redirect:/login";
	}
}