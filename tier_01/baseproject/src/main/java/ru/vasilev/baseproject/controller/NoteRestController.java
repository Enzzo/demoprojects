package ru.vasilev.baseproject.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.vasilev.baseproject.model.Note;
import ru.vasilev.baseproject.service.NoteService;

@RestController
@RequestMapping("/v1/api/notes")
public class NoteRestController {
	private final NoteService noteService;

	public NoteRestController(NoteService noteService) {
		this.noteService = noteService;
	}
	
	@GetMapping
	public List<Note> getAllNotes() {
		return noteService.findAllNotes();
	}
	
	@PostMapping
	public Note postNote(@RequestBody Note note){
		return noteService.create(note);
	}
}