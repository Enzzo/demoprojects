package ru.vasilev.baseproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ru.vasilev.baseproject.model.Note;
import ru.vasilev.baseproject.service.NoteService;

@Controller
@RequestMapping("/notes")
public class NoteController {
	private final NoteService noteService;

	public NoteController(NoteService noteService) {
		this.noteService = noteService;
	}
	
	@PostMapping
	public String addNote(@ModelAttribute Note note) {
		noteService.create(note);
		return "redirect:/";
	}
}