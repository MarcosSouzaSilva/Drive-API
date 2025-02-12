package br.com.curso.infrastructure;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Swagger OpenApi", version = "1", description = "Api desenvolvida pra aplicar a arquitetura limpa"))
@EnableScheduling
public class InfrastructureApplication2 {
    public static void main(String[] args) {
        SpringApplication.run(InfrastructureApplication2.class, args);
    }
}