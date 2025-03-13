package ru.vasilev.librarysystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	private String isbn;
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "author_id")
	private Author author;

	@Builder
	public Book(String title, String isbn, String status, Author author) {
		this.title = title;
		this.isbn = isbn;
		this.status = status;
		this.author = author;
	}	
}
