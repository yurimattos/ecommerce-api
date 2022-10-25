package br.com.serratec.ecommerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
	@Bean
	public OpenAPI springShopOpenAPI() {
		return new OpenAPI()
				.info(new Info().title("Ecommerce Serratec API Grupo 1")
				.description("API de ecommerce desenvolvida pelo Grupo 1 para a Residência de Software 2022.2")
				.version("v1.0"));
	}
}