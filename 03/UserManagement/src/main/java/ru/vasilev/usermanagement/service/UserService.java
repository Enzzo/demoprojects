package ru.vasilev.usermanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.vasilev.usermanagement.model.User;
import ru.vasilev.usermanagement.repository.UserRepository;

@Service
@Transactional
public class UserService {
	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;
	
	public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	@Transactional(readOnly = true)
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	@Transactional(readOnly = true)
	public Optional<User> findUserById(Integer id) {
		return userRepository.findById(id);
	}
	
	@Transactional(readOnly = true)
	public Optional<User> findUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	public User save(User user) {
		user.setPassword(hashPassword(user.getPassword()));
		return userRepository.save(user);
	}

	public void update(Integer id, User user) {
		user.setId(id);
	}

	public void delete(User user) {
		userRepository.delete(user);
	}
	
	public void deleteUserById(Integer id) {
		userRepository.deleteById(id);
	}
	
	private String hashPassword(String password) {
		return passwordEncoder.encode(password);
	}
}
