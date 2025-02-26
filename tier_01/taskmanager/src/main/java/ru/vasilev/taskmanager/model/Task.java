package ru.vasilev.taskmanager.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String title;
	
	private String description;
	
	private Status status;
	
	private LocalDateTime createdAt;

	public Task(String title, String description, Status status) {
		this.title = title;
		this.description = description;
		this.status = status;
	}
}

enum Status {
	NEW, IN_PROGRESS, DONE
};