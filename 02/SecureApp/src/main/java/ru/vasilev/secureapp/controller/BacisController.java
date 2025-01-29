package ru.vasilev.secureapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BacisController {
	@GetMapping("/")
	public String getIndex(Model model) {
		model.addAttribute("message", "Welcome to homepage");
		return "index";
	}
	
	@GetMapping("/admin")
	public String getAdminIndex(Model model) {
		model.addAttribute("message", "Welcome to admin page");
		return "admin";
	}
	
	@GetMapping("/login")
	public String getLogin(Model model) {
		return "login";
	}
}
