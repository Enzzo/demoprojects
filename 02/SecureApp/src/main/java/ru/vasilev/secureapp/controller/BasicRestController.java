package ru.vasilev.secureapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BasicRestController {
	@GetMapping("/public")
	public String getRestPublic(){
		return "{\"message\": \"This is a public API\"}";
	}
	
	@GetMapping("/admin")
	public String getRestAdmin(){
		return "{\"message\": \"This is an admin-only API\"}";
	}
}