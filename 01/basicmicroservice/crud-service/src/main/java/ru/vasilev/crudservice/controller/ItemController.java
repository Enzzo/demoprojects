package ru.vasilev.crudservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {
	@GetMapping("/items")
	public String getItems() {
		return "getitems";
	}
}