package br.com.curso.infrastructure.in.config;

import br.com.curso.usecases.CreateCustomerUseCaseImpl;
import br.com.curso.usecases.CreateUserUseCaseImpl;
import br.com.curso.usecases.CreateVehicleUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configs {


    @Bean
    public CreateUserUseCaseImpl createUserUseCase() {
        return new CreateUserUseCaseImpl();
    }

    @Bean
    public CreateVehicleUseCaseImpl createVehicleUseCase() {
        return new CreateVehicleUseCaseImpl();
    }

    @Bean
    public CreateCustomerUseCaseImpl createCustomerUseCase() {
        return new CreateCustomerUseCaseImpl();
    }



}