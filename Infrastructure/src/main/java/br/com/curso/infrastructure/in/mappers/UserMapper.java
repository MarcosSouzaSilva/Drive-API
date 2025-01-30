package br.com.curso.infrastructure.in.mappers;

import br.com.curso.domain.User;
import br.com.curso.exceptions.InvalidEmailException;
import br.com.curso.exceptions.InvalidCredentialsException;
import br.com.curso.infrastructure.domain.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {


    public UserEntity toUserEntity(User user) throws InvalidCredentialsException, InvalidEmailException {

        UserEntity entity = new UserEntity();

        entity.setPassword(user.getPassword());
        entity.setEmail(user.getEmail());

        return entity;
    }
}