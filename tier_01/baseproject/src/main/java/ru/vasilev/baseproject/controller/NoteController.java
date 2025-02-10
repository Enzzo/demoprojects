package ru.vasilev.baseproject.controller;

import ru.vasilev.baseproject.service.NoteService;

public class NoteController {
	private final NoteService noteService;

	public NoteController(NoteService noteService) {
		this.noteService = noteService;
	}
}