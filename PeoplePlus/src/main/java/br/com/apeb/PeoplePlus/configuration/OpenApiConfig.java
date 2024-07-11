package br.com.apeb.PeoplePlus.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class OpenApiConfig {

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.components(
						new Components().addSecuritySchemes("bearerAuth",
								new SecurityScheme().type(SecurityScheme.Type.HTTP)
									.scheme("bearer").bearerFormat("JWT")
								)
						)
				.info(
						new Info()
							.title("App de gestão de Clientes e seus Contatos")
							.description("Este app faz gestão de cadastro de clientes" + 
							             " bem como de seus contatos telefônicos.")
							.contact(new Contact()
										.name("Ana Paula Esteves Berti")
										.email("anapaulaeberti@gmail.com")
										.url("http://localhost:8081")
									)
							.version("Versão 0.0.1-SNAPSHOT")
						)
				.addSecurityItem(new SecurityRequirement().addList("bearerAuth"));
				
	}
	
}