package ru.vasilev.basicsecurity.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ru.vasilev.basicsecurity.model.User;
import ru.vasilev.basicsecurity.repository.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findByUsername(String username) {
		return userRepository.findByUsername(username).orElseGet(null);
	}
	
	public User save(User user) {
		return userRepository.save(user);
	}
	
	public void delete(User user) {
		userRepository.delete(user);
	}
}