package ru.vasilev.securenote.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
//	@Bean
//	UserDetailsService userDetailsService() {
//		return null;
//	}
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http
		.headers(headers -> headers.frameOptions().disable()) // <== Отключаем защиту от iframe
        .csrf(csrf -> csrf.ignoringRequestMatchers("/h2-console/**")) // <== Отключаем CSRF для H2 Console
		.authorizeHttpRequests(auth -> auth
				.requestMatchers("/",
						"/h2-console/**",
						"/swagger-ui.html", 
						"/swagger-ui/**",
						"/api/**")
				.permitAll()
				);
		return http.build();
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}