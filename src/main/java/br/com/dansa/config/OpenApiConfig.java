package br.com.dansa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {
	
	@Bean
	public OpenAPI api() {
		return new OpenAPI()
				.info(new Info()
						.title("RESTful API with Java 11 and Spring Boot 2.6.4")
						.version("v1")
						.description("Projeto realizado na udemy")
						.termsOfService("http://swagger.io/terms")
						.license(new License().name("Apache 2.0")
								.url("http://springdoc.org")));
	}

}
