package br.com.curso.infrastructure.in.controllers;

import br.com.curso.domain.Customer;
import br.com.curso.exceptions.CustomerCreationException;
import br.com.curso.exceptions.InvalidCredentialsException;
import br.com.curso.exceptions.InvalidEmailException;
import br.com.curso.exceptions.InvalidPhoneNumberException;
import br.com.curso.exceptions.InvalidTaxIdException;
import br.com.curso.exceptions.UserCreationException;
import br.com.curso.exceptions.VehicleCreationException;
import br.com.curso.infrastructure.in.config.security.SecurityConfigs;
import br.com.curso.infrastructure.in.service.CustomerService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

@RestController
@RequestMapping("api/v1/customer")
@Tag(name = "api-clean-architecture", description = "Learning hateoas and swagger")
@SecurityRequirement(name = SecurityConfigs.SECURITY)
public class CustomerController {

    private CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }


    @Operation(summary = "Register User", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User registration successful"),
            @ApiResponse(responseCode = "422", description = "Invalid request data"),
            @ApiResponse(responseCode = "400", description = "Invalid parameters"),
            @ApiResponse(responseCode = "500", description = "Server error"),
    })
    @PostMapping(value = "/createCustomer", consumes = MediaType.APPLICATION_JSON_VALUE)
    public EntityModel<Customer> createCustomer(@RequestBody Customer customer) throws InvalidTaxIdException, InvalidEmailException, CustomerCreationException, UserCreationException, InvalidCredentialsException, VehicleCreationException, InvalidPhoneNumberException {
        return service.createCustomer(customer);
    }

}