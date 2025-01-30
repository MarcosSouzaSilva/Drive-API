package br.com.curso.usecases;

import br.com.curso.domain.Customer;
import br.com.curso.exceptions.CustomerCreationException;
import br.com.curso.exceptions.InvalidCredentialsException;
import br.com.curso.exceptions.InvalidTaxIdException;
import br.com.curso.exceptions.InvalidEmailException;
import br.com.curso.exceptions.InvalidPhoneNumberException;

public interface CreateCustomerUseCase {

     Customer createCustomer(Customer customer) throws CustomerCreationException, InvalidPhoneNumberException, InvalidTaxIdException, InvalidEmailException, InvalidCredentialsException;


}