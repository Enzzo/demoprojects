package ru.vasilev.authservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http
			.csrf(csrf->csrf.disable())
			.authorizeHttpRequests(auth -> auth
					.requestMatchers("/login", "/swagger-ui/**", "/v3/api/docs/**").permitAll()
					.anyRequest().authenticated())
			.httpBasic(Customizer.withDefaults());
		return http.build();
	}
}