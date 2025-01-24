package ru.vasilev.usermanagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeHttpRequests(auth -> auth
					.requestMatchers("/",
							"/login",
							"/swagger-ui.html",
							"/swagger-ui/**",
							"/v3/api-docs/**",
							"api-docs/**")
					.permitAll()
					.requestMatchers("/api/users", "/api/users/**").hasRole("ADMIN")
					.anyRequest().authenticated()
				)
            .formLogin().and()
            .httpBasic();
		return http.build();
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder) {
		UserDetails admin = User.withUsername("admin")
				.password(passwordEncoder.encode("password"))
				.roles("ADMIN")
				.build();
		UserDetails user = User.withUsername("user")
				.password(passwordEncoder.encode("password"))
				.roles("USER")
				.build();
		
		return new InMemoryUserDetailsManager(user, admin);
	}
}