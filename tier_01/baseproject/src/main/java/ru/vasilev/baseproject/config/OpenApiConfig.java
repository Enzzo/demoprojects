package ru.vasilev.baseproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {
	
	@Bean
	OpenAPI customOpenApi() {
		return new OpenAPI()
				.info(new Info()
						.title("BaseProject API")
						.version("1.1")
						.description("Документация для API проекта 1.1"));
	}
}