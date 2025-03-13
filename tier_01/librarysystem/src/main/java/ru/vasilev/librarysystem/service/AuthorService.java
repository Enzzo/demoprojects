package ru.vasilev.librarysystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.vasilev.librarysystem.model.Author;
import ru.vasilev.librarysystem.repository.AuthorRepository;

@Service
public class AuthorService {
	private final AuthorRepository authorRepo;

	@Autowired
	public AuthorService(AuthorRepository authorRepo) {
		this.authorRepo = authorRepo;
	}
	
	public List<Author> findAll(){
		return authorRepo.findAll();
	}
	
	public Optional<Author> findById(Long id){
		return authorRepo.findById(id);
	}
	
	public Author save(Author author) {
		return authorRepo.save(author);
	}
	
	public Optional<Author> update(Long id, Author authorDetails){
		return authorRepo.findById(id)
				.map(author -> {
					author.setName(authorDetails.getName());
					author.setBooks(authorDetails.getBooks());
					return authorRepo.save(author);
				});
	}
	
	public void delete(Long id) {
		authorRepo.deleteById(id);
	}
}
