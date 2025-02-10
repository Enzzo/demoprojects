package ru.vasilev.baseproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import ru.vasilev.baseproject.service.NoteService;

@Controller
public class HomeController {
	private final NoteService noteService;
	
	public HomeController(NoteService noteService) {
		this.noteService = noteService;
	}

	@GetMapping
	public String homePage(Model model) {
		model.addAttribute("notes", noteService.findAllNotes());
		return "index";
	}
	
	@PostMapping
	public String postNote() {
		return "redirect:/";
	}
}
