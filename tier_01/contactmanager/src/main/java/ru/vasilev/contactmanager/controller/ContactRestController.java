package ru.vasilev.contactmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import ru.vasilev.contactmanager.model.Contact;
import ru.vasilev.contactmanager.service.ContactService;

@Tag(name = "Contact Manager", description = "API для управления контактами")
@RestController
@RequestMapping("/v1/api/contacts")
public class ContactRestController {
	private final ContactService contactService;

	@Autowired
	public ContactRestController(ContactService contactService) {
		this.contactService = contactService;
	}
	
	@Operation(summary = "Список контактов", description = "Получить список всех контактов")
	@GetMapping
	public List<Contact> findAll(){
		return contactService.findAll();
	}
	
	@Operation(summary = "Получить контакт по ID", description = "Получить список контакта по ID")
	@GetMapping("/{id}")
	public ResponseEntity<Contact> findById(@PathVariable Long id){
		return contactService.findById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@Operation(summary = "Получить контакт по email", description = "Получить список контакта по email")
	@GetMapping("/{email}")
	public ResponseEntity<Contact> findById(@PathVariable String email){
		return contactService.findByEmail(email)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@Operation(summary = "Создать контакт", description = "Создаёт новый контакт")
	@PostMapping
	public ResponseEntity<Contact> create(@RequestBody Contact contact){
		return ResponseEntity.ok(contactService.create(contact));
	}
	
	@Operation(summary = "Обновить контакт по ID", description = "Обновляет контакт по ID")
	@PutMapping("/{id}")
	public ResponseEntity<Contact> update(@PathVariable Long id, @RequestBody Contact contact){
		return contactService.update(id, contact)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@Operation(summary = "Удалить контакт по ID", description = "Удаляет контакт по ID")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		contactService.delete(id);
		return ResponseEntity.noContent().build();
	}
}