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
}