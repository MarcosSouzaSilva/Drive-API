package br.com.curso.infrastructure.in.controllers;

import br.com.curso.domain.User;
import br.com.curso.exceptions.InvalidEmailException;
import br.com.curso.exceptions.InvalidCredentialsException;
import br.com.curso.exceptions.UserCreationException;
import br.com.curso.infrastructure.in.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public ResponseEntity<?> createUser(@RequestBody User user) throws Exception {

        return service.createUser(user);
    }

}