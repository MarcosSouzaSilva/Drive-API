package br.com.curso.infrastructure.in.controllers;

import br.com.curso.domain.Customer;
import br.com.curso.exceptions.CustomerCreationException;
import br.com.curso.exceptions.InvalidCredentialsException;
import br.com.curso.exceptions.InvalidTaxIdException;
import br.com.curso.exceptions.InvalidEmailException;
import br.com.curso.exceptions.InvalidPhoneNumberException;
import br.com.curso.exceptions.UserCreationException;
import br.com.curso.exceptions.VehicleCreationException;
import br.com.curso.infrastructure.domain.entity.CustomerEntity;
import br.com.curso.infrastructure.in.service.CustomerService;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {

    private CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @PostMapping("/createCustomer")
    public EntityModel<Customer> createCustomer(@RequestBody Customer customer) throws InvalidTaxIdException, InvalidEmailException, CustomerCreationException, UserCreationException, InvalidCredentialsException, VehicleCreationException, InvalidPhoneNumberException {

        return service.createCustomer(customer);
    }

    @DeleteMapping("/deleteCustomer")
    public CustomerEntity deleteUser(Customer customer) {
        return service.deleteUser();
    }

    @PutMapping("/updateCustomer")
    public CustomerEntity updateUser(Customer customer) {
        return service.updateUser();
    }
}