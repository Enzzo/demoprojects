package ru.vasilev.taskmanager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import ru.vasilev.taskmanager.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	private final UserDetailsServiceImpl userDetailsService;

	public SecurityConfig(UserDetailsServiceImpl userDetailsService) {
		this.userDetailsService = userDetailsService;
	}
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http
			.csrf(AbstractHttpConfigurer::disable)
			.authorizeHttpRequests(auth -> auth
					.requestMatchers("/swagger-ui.html",
							"/swagger-ui/**",
		                    "/v3/api-docs/**",
		                    "/swagger-resources/**",
		                    "/webjars/**",
		                    "/api/auth/**")
					.permitAll()
					.anyRequest().authenticated()
					)
			.userDetailsService(userDetailsService)
			.sessionManagement(session -> session
					.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		);
		return http.build();
	}
}