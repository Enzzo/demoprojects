package ru.vasilev.taskmanager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

// закомментировали, потому что liquibase сам создаст
@Entity
@Table(name = "tasks")
@NoArgsConstructor
@Data
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private boolean completed;
	
	public Task(String title, boolean completed) {
		this.title = title;
		this.completed = completed;
	}
}