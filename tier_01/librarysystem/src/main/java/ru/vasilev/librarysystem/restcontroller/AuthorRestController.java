package ru.vasilev.librarysystem.restcontroller;

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

import ru.vasilev.librarysystem.model.Author;
import ru.vasilev.librarysystem.model.Book;
import ru.vasilev.librarysystem.service.AuthorService;

@RestController
@RequestMapping("/v1/api/authors")
public class AuthorRestController {
	private final AuthorService authorService;

	@Autowired
	public AuthorRestController(AuthorService authorService) {
		this.authorService = authorService;
	}
	
	@GetMapping
	public ResponseEntity<List<Author>> getAll() {
		return ResponseEntity.ok(authorService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Author> getById(@PathVariable Long id){
		return authorService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Author> post(@RequestBody Author author){
		return ResponseEntity.ok(authorService.save(author));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Author> put(@PathVariable Long id, @RequestBody Author author){
		return authorService.update(id, author)
				.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		authorService.delete(id);
		return ResponseEntity.noContent().build();
	}
}