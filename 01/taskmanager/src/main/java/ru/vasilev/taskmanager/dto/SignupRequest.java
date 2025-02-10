package ru.vasilev.taskmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SignupRequest {
	private final String username;
	private final String password;
}