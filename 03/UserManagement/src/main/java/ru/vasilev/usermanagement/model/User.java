package ru.vasilev.usermanagement.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false, unique = true)
	@NotBlank(message = "Имя не может быть пустым")
	@Size(min = 3, message = "Имя должно содержать минимум 3 символа")
	private String username;
	
	@Column(nullable = false)
	@NotBlank(message = "Пароль не может быть пустым")
	@Size(min = 6, message = "Пароль должен быть не менее 6 символов")
	private String password;
	
	@Column(nullable = false)
	@NotBlank(message = "Роль не может быть пустая")
	@Pattern(regexp = "USER|ADMIN", message = "Роль должна быть USER или ADMIN")
	private String role;

	public User(String username, String password, String role) {
		this.username = username;
		this.password = password;
		this.role = role;
	}
}