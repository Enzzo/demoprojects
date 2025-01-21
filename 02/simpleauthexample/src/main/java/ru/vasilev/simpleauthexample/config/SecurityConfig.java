package ru.vasilev.simpleauthexample.config;

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
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests(auth -> auth
					.requestMatchers("/"
							, "/login"
							, "/swagger-ui.html"
							, "/swagger-ui/**"
							, "/v3/api-docs/**"
							, "/api-docs/**")
					.permitAll()
					.anyRequest().authenticated()
					)
			.formLogin(form -> form
					.loginPage("/login")
					.defaultSuccessUrl("/secure", true)
					.permitAll()
					)
			.logout(logout -> logout
					.logoutSuccessUrl("/")
					.permitAll()
					);
		return http.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println(encoder.encode("admin"));
		System.out.println(encoder.encode("password"));
		return encoder;
	}
	
	@Bean
	public InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder) {
		UserDetails admin = User.withUsername("admin")
				.password("admin")
				.roles("ADMIN")
				.build();
		UserDetails user = User.withUsername("user")
				.password("password")
				.roles("USER")
				.build();
		
		return new InMemoryUserDetailsManager(user, admin);
	}
}