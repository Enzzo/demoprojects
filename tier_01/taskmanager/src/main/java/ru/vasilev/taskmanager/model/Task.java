package ru.vasilev.taskmanager.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "tasks")
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String title;
	
	@Column(length = 500)
	private String description;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	private LocalDateTime createdAt;

	public enum Status {
		NEW, IN_PROGRESS, DONE
	}
	
	public Task(String title, String description, Status status) {
		this.title = title;
		this.description = description;
		this.status = status;
		this.createdAt = LocalDateTime.now();
	}
	
	public Task() {
		this.status = Status.NEW;
		this.createdAt = LocalDateTime.now();
	}
}