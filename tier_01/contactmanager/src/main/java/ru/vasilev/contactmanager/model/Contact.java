package ru.vasilev.contactmanager.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table(name = "contacts")
public class Contact {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min = 3, max = 255, message = "Имя должно быть от 3 до 255 символов")
	@Column(unique = true)
	private String name;
	
	@NotNull
	@Size(min = 3, max = 255, message = "mail должен быть от 3 до 255 символов")
	private String email;
	
	@NotNull
	@Size(max = 20)
	private String phone;
}