package ru.vasilev.basicsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
		http
		.authorizeHttpRequests(auth -> auth
//				.requestMatchers("/",
//						"/v1/api/",
//						"/login", 
//						"/register", 
//						"/public/**",
//						"/swagger-ui/**",
//						"/h2-console/**"
//						)
//				.permitAll()
				.anyRequest().permitAll())
		.csrf(csrf -> csrf
				.ignoringRequestMatchers("/v1/api/**", "/v3/api/**", "/h2-console/**"))
		.formLogin(form -> form
				.loginPage("/login")
				.defaultSuccessUrl("/", true)
				.permitAll()
				);
		return http.build();
	}
}