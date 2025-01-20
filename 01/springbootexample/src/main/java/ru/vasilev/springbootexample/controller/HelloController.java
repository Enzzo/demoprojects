package ru.vasilev.springbootexample.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api")
@Tag(name = "Контроллер для работы с приветствиями")
public class HelloController {
	
	@GetMapping("/hello")
	@Operation(summary = "Получить приветствие", description = "Возвращает сообщение 'Hello, World!' в формате JSON")
	public ResponseEntity<String> sayHello() {
		return ResponseEntity.ok("Hello, World!");
	}
}

@Controller
class HelloThymeleafController {

	@GetMapping
	public String sayHello(Model model) {
		model.addAttribute("message", "Hello world");
		return "index";
	}
}