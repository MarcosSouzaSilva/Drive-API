package br.com.curso.infrastructure.in.service;

import br.com.curso.domain.Customer;
import br.com.curso.exceptions.CustomerCreationException;
import br.com.curso.exceptions.InvalidCredentialsException;
import br.com.curso.exceptions.InvalidTaxIdException;
import br.com.curso.exceptions.InvalidEmailException;
import br.com.curso.exceptions.InvalidPhoneNumberException;
import br.com.curso.exceptions.UserCreationException;
import br.com.curso.exceptions.VehicleCreationException;
import br.com.curso.infrastructure.domain.entity.CustomerEntity;
import br.com.curso.infrastructure.in.controllers.CustomerController;
import br.com.curso.infrastructure.in.mappers.CustomerMapper;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import br.com.curso.infrastructure.out.repository.CustomerJpaRepository;
import br.com.curso.usecases.CreateCustomerUseCaseImpl;
import jakarta.transaction.Transactional;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CreateCustomerUseCaseImpl createCustomerUseCaseImpl;

    private final CustomerMapper customerMapper;

    private final PasswordEncoder securityConfig;

    private final CustomerJpaRepository customerJpaRepository;


    public CustomerService(CreateCustomerUseCaseImpl createCustomerUseCaseImpl, CustomerMapper customerMapper, PasswordEncoder securityConfig, CustomerJpaRepository customerJpaRepository) {
        this.createCustomerUseCaseImpl = createCustomerUseCaseImpl;
        this.customerMapper = customerMapper;
        this.securityConfig = securityConfig;
        this.customerJpaRepository = customerJpaRepository;
    }

    @Transactional
    public EntityModel<Customer> createCustomer(Customer customer) throws InvalidPhoneNumberException, InvalidTaxIdException, InvalidEmailException, CustomerCreationException, UserCreationException, InvalidCredentialsException, VehicleCreationException {
        Customer useCaseCustomer = createCustomerUseCaseImpl.createCustomer(customer);

        var entity = customerMapper.toCustomerEntity(useCaseCustomer);

        if (customerJpaRepository.findByEmail(entity.getEmail()).isPresent()) throw new UserCreationException();

        entity.setPassword(securityConfig.encode(entity.getPassword()));

        EntityModel<Customer> resource = EntityModel.of(customer);

        var addLinks = resource.add(
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CustomerController.class).createCustomer(customer)).withRel("Create User")
        );

        customerJpaRepository.save(entity);

        return addLinks;

    }

}