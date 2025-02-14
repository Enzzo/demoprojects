package ru.vasilev.authservice.service;

import java.util.Collections;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ru.vasilev.authservice.model.Role;
import ru.vasilev.authservice.model.User;
import ru.vasilev.authservice.repository.RoleRepository;
import ru.vasilev.authservice.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	private final PasswordEncoder passwordEncoder;
	private final UserRepository userRepository;
	private final RoleRepository roleRepository;

	public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository,
			RoleRepository roleRepository) {
		this.passwordEncoder = passwordEncoder;
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
	}

	@Override
	public void save(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		Role userRole = roleRepository.findByName("ROLE_USER")
				.orElseGet(() -> roleRepository.save(new Role("ROLE_USER", null)));
		user.setRoles(Collections.singleton(userRole));
		userRepository.save(user);
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username).orElse(null);
	}

}
