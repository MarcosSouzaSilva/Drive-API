package br.com.curso.usecases;

import br.com.curso.domain.User;
import br.com.curso.exceptions.InvalidCredentialsException;
import br.com.curso.exceptions.InvalidEmailException;
import br.com.curso.exceptions.UserCreationException;

import java.util.regex.Pattern;


public class CreateUserUseCaseImpl implements CreateUserUseCase {


    private final Pattern patternPassword = Pattern.compile("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");

    private final Pattern patternEmail = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");


    public CreateUserUseCaseImpl() {
    }

    @Override
    public User createUser(User user) throws UserCreationException, InvalidCredentialsException, InvalidEmailException {
        if (user == null) throw new UserCreationException();

        if (!user.getPassword().matches(patternPassword.pattern())) throw new InvalidCredentialsException();

        if (!user.getEmail().matches(patternEmail.pattern())) throw new InvalidEmailException();



        return user;
    }


}