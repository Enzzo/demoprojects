package ru.vasilev.librarysystem.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ru.vasilev.librarysystem.model.Book;
import ru.vasilev.librarysystem.service.BookService;

@RestController
@RequestMapping("/v1/api/books")
public class BookRestController {
	private final BookService bookService;

	@Autowired
	public BookRestController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@GetMapping
	public ResponseEntity<List<Book>> getAllBooks(){
		return ResponseEntity.ok(bookService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Book> getById(@PathVariable Long id){
		return bookService.findById(id)
			.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/search")
	public ResponseEntity<List<Book>> searchByTitle(@RequestParam String title){
		return ResponseEntity.ok(bookService.findByTitle(title));
	}
	
	@PostMapping
	public ResponseEntity<Book> post(@RequestBody Book book){
		return ResponseEntity.ok(bookService.save(book));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Book> put(@PathVariable Long id, @RequestBody Book book){
		return bookService.update(id, book)
				.map(ResponseEntity::ok)
				.orElseGet(()->ResponseEntity.notFound().build());
	}
	
	@PatchMapping("/{id}/status")
	public ResponseEntity<Book> patch(@PathVariable Long id, @RequestParam String status){
		return bookService.updateStatus(id,  status)
				.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		bookService.delete(id);
		return ResponseEntity.noContent().build();
	}
}