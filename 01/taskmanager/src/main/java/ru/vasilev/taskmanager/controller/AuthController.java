package ru.vasilev.taskmanager.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.vasilev.taskmanager.dto.LoginRequest;
import ru.vasilev.taskmanager.dto.SignupRequest;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@PostMapping("/signup")
	public ResponseEntity<?> signup(@RequestBody SignupRequest request){
		return ResponseEntity.ok("");
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequest request){
		return ResponseEntity.ok("");
	}
}