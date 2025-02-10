package ru.vasilev.baseproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api")
public class HomeRestController {
	@GetMapping("/message")
	public String homePage() {
		return "{ \"message\" : \"hello\"}";
	}
}