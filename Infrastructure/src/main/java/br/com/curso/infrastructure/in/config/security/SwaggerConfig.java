package br.com.curso.infrastructure.in.config.security;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;

@Configuration
public class SwaggerConfig {




    @Bean
    public OpenAPI custoAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("API - Clean Architecture")
                        .version("1.0.0")
                        .description("Documentação da API"))
                .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
                .components(new io.swagger.v3.oas.models.Components()
                        .addSecuritySchemes("bearerAuth", new SecurityScheme()
                                .name("bearerAuth")
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")));
    }
}
