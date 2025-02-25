package ru.vasilev.authservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthController {
	@GetMapping
	public String homePage(Model model) {
		model.addAttribute("message", "auth-service");
		return "index";
	}
}