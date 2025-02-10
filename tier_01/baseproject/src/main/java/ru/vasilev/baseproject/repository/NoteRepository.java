package ru.vasilev.baseproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.vasilev.baseproject.model.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long>{
	Optional<Note> findByContent(String contend);
}