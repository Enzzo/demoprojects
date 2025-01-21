package ru.vasilev.simpleauthexample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	@GetMapping
	public String homePage() {
		return "home";
	}
	
	@GetMapping("/secure")
	public String securePage() {
		return "secure";
	}
	
	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}
//	
//	@PostMapping("/login")
//	public String login() {
////			@RequestParam("login") String login,
////			@RequestParam("password") String password) {
////		System.out.printf("login: %s\npassword: %s\n", login, password);
//		return "redirect:/secure";
//	}
}