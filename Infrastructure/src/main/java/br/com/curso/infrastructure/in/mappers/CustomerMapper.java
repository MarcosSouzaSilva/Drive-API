package br.com.curso.infrastructure.in.mappers;

import br.com.curso.domain.Customer;
import br.com.curso.exceptions.InvalidCredentialsException;
import br.com.curso.exceptions.InvalidTaxIdException;
import br.com.curso.exceptions.InvalidEmailException;
import br.com.curso.infrastructure.domain.entity.CustomerEntity;

import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public CustomerEntity toCustomerEntity(Customer customer) throws InvalidEmailException, InvalidTaxIdException, InvalidCredentialsException {
        CustomerEntity entity = new CustomerEntity();

        entity.setName(customer.getName());
        entity.setEmail(customer.getEmail());
        entity.setTaxId(customer.getTaxId());
        entity.setAddress(customer.getAddress());
        entity.setPassword(customer.getPassword());
        entity.setPhoneNumber(customer.getPhoneNumber());

        return entity;
    }

}