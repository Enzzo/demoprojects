package ru.vasilev.usermanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.vasilev.usermanagement.model.Person;
import ru.vasilev.usermanagement.repository.UserRepository;

@Service
@Transactional
public class UserService {
	private UserRepository userRepository;
	
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Transactional(readOnly = true)
	public List<Person> findAll(){
		return userRepository.findAll();
	}
	
	@Transactional(readOnly = true)
	public Optional<Person> findUserById(Integer id) {
		return userRepository.findById(id);
	}
	
	@Transactional(readOnly = true)
	public Optional<Person> findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	public Person save(Person user) {
		return userRepository.save(user);
	}

	public void update(Integer id, Person user) {
		user.setId(id);
	}

	public void delete(Person user) {
		userRepository.delete(user);
	}
	
	public void deleteUserById(Integer id) {
		userRepository.deleteById(id);
	}
}
