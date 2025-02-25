package ru.vasilev.authservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import ru.vasilev.authservice.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http
			.csrf(csrf->csrf.disable())
			.authorizeHttpRequests(auth -> auth
					.requestMatchers("/login", 
							"/swagger-ui/**", 
							"/v3/api/docs/**",
							"/registration").permitAll()
					.anyRequest().authenticated())
//			.httpBasic(Customizer.withDefaults());
			.formLogin(form -> form.loginPage("/login").permitAll());
		return http.build();
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl();
	}
}