package br.com.curso.usecases;

import br.com.curso.domain.User;
import br.com.curso.exceptions.InvalidCredentialsException;
import br.com.curso.exceptions.InvalidEmailException;
import br.com.curso.exceptions.UserCreationException;

public interface CreateUserUseCase {

     User createUser(User user) throws UserCreationException, InvalidCredentialsException, InvalidEmailException;

}