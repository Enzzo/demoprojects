package ru.vasilev.librarysystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.vasilev.librarysystem.model.Book;
import ru.vasilev.librarysystem.repository.BookRepository;

@Service
public class BookService {
	private final BookRepository bookRepo;

	@Autowired
	public BookService(BookRepository bookRepo) {
		this.bookRepo = bookRepo;
	}
	
	public List<Book> findAll(){
		return bookRepo.findAll();
	}
	
	public Optional<Book> findById(Long id){
		return bookRepo.findById(id);
	}
	
	public List<Book> findByTitle(String title){
		return bookRepo.findByTitleContainingIgnoreCase(title);
		
	}
	
	public Book save(Book book) {
		return bookRepo.save(book);
	}
	
	public Optional<Book> update(Long id, Book bookDetails) {
		return bookRepo.findById(id)
				.map(book -> {
					book.setTitle(bookDetails.getTitle());
					book.setIsbn(bookDetails.getIsbn());
					book.setStatus(bookDetails.getStatus());
					book.setAuthor(bookDetails.getAuthor());
					return bookRepo.save(book);
				});
	}
	
	public Optional<Book> updateStatus(Long id, String status){
		return bookRepo.findById(id)
				.map(book -> {
					book.setStatus(status);
					return bookRepo.save(book);
				});
	}
	
	public void delete(Long id) {
		bookRepo.deleteById(id);
	}
}