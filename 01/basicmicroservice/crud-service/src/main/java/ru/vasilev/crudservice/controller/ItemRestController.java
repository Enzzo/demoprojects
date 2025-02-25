package ru.vasilev.crudservice.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import ru.vasilev.crudservice.model.Item;
import ru.vasilev.crudservice.service.ItemService;

@RestController
@RequestMapping("/v1/api/items")
public class ItemRestController {
	private ItemService itemService;

	public ItemRestController(ItemService itemService) {
		this.itemService = itemService;
	}
	
	@Operation(summary = "Получить список всех элементов")
	@GetMapping
	public ResponseEntity<List<Item>> getAllItems(){
		return ResponseEntity.ok(itemService.findAll());
	}
	
	@Operation(summary = "Сохранить элемент в базу")
	@PostMapping
	public ResponseEntity<Item> saveItem(@RequestBody Item item) {
		return ResponseEntity.ok(itemService.saveItem(item));
	}
}