package ru.vasilev.usermanagement.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ru.vasilev.usermanagement.model.Person;
import ru.vasilev.usermanagement.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	private final UserRepository userRepository;
	
	public CustomUserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {		
		Person user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Пользователь не найден: " + username));
		return User.withUsername(user.getUsername())
				.password(user.getPassword())
				.roles(user.getRole())
				.build();
	}	
}