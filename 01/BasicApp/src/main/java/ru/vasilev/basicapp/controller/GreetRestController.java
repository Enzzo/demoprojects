package ru.vasilev.basicapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GreetRestController {
	
	@GetMapping("/greet")
	public String getGreet(){
		return "{\"message\": \"Hello from basic app\"}";
	}
}