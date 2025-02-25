package ru.vasilev.basicsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.vasilev.basicsecurity.service.UserService;

@RestController
@RequestMapping("/v1/api")
public class UserRestController {
	private UserService userService;

	public UserRestController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/")
	public String homePage() {
		return "Это общая страница";
	}
	
	@GetMapping("/user")
	public String userPage() {
		return "Страница пользователя";
	}
	
	@GetMapping("/admin")
	public String adminPage() {
		return "Страница админа";
	}
}