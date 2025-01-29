package ru.vasilev.securenote.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ru.vasilev.securenote.model.User;
import ru.vasilev.securenote.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {
	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;
	
	public void registerUser(String username, String password) {
		User user = new User(username, passwordEncoder.encode(password));
		userRepository.save(user);
	}
}
