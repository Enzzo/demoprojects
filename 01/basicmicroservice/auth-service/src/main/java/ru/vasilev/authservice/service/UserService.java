package ru.vasilev.authservice.service;

import org.springframework.stereotype.Service;

import ru.vasilev.authservice.model.User;

@Service
public interface UserService {
	void save(User user);
	User findByUsername(String username);
}