package ru.vasilev.contactmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import ru.vasilev.contactmanager.model.Contact;
import ru.vasilev.contactmanager.service.ContactService;

@Slf4j
@Controller
@RequestMapping("/contacts")
public class ContactController {
	private final ContactService contactService;

	@Autowired
	public ContactController(ContactService contactService) {
		this.contactService = contactService;
	}
	
	@ModelAttribute("contact")
	public Contact createContact() {
		return new Contact();
	}
	
	@GetMapping
	public String findAll(Model model) {
		model.addAttribute("contacts", contactService.findAll());
		return "contacts";
	}
	
	@GetMapping("/new")
	public String newContact() {
		return "new";
	}
	
	@PostMapping
	public String createContact(@Valid Contact contact, Errors errors) {
		if(errors.hasErrors()) {
			return "new";
		}
		contactService.create(contact);
		return "redirect:/contacts";
	}
	
	@PostMapping("/update/{id}")
	public String updateContact(@PathVariable Long id, Contact contact, Errors errors) {
		if(errors.hasErrors()) {
			return "new";
		}
		contactService.update(id, contact);
		return "redirect:/contacts";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteContact(@PathVariable Long id) {
		contactService.delete(id);
		return "redirect:/contacts";
	}
	
	@GetMapping("/edit/{id}")
	public String editContact(@PathVariable Long id, Model model) {
		model.addAttribute("contact", contactService.findById(id).orElseThrow());
		return "new";
	}
}