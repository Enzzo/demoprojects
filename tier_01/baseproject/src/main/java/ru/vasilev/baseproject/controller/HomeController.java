package ru.vasilev.baseproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ru.vasilev.baseproject.model.Note;
import ru.vasilev.baseproject.service.NoteService;

@Controller
public class HomeController {
	private final NoteService noteService;
	
	public HomeController(NoteService noteService) {
		this.noteService = noteService;
	}

	@GetMapping
	public String homePage(Model model) {
		model.addAttribute("note", new Note());
		model.addAttribute("notes", noteService.findAllNotes());
		return "index";
	}
}
