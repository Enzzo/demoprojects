package ru.vasilev.baseproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ru.vasilev.baseproject.model.Note;
import ru.vasilev.baseproject.repository.NoteRepository;

@Service
public class NoteService {
	private final NoteRepository noteRepository;

	public NoteService(NoteRepository noteRepository) {
		this.noteRepository = noteRepository;
	}
	
	public List<Note> findAllNotes(){
		return noteRepository.findAll();
	}
	
	public Note findById(Long id){
		return noteRepository.findById(id).orElse(new Note());
	}
	
	public Note findByContent(String content) {
		return noteRepository.findByContent(content).orElse(new Note());
	}
	
	public Note create(Note note) {
		return noteRepository.save(note);
	}
	
	public Note update(Long id, Note note) {
		note.setId(id);
		return noteRepository.save(note);
	}
	
	public void delete(Long id) {
		noteRepository.deleteById(id);
	}
}