package ru.vasilev.basicapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetController {
	@GetMapping
	public String getGreet(Model model) {
		model.addAttribute("message", "Hello from basic app");
		return "index";
	}
}