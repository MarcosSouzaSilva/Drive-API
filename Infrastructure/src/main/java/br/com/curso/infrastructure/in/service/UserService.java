package br.com.curso.infrastructure.in.service;

import br.com.curso.domain.Customer;
import br.com.curso.domain.User;
import br.com.curso.exceptions.InvalidEmailException;
import br.com.curso.exceptions.InvalidCredentialsException;
import br.com.curso.exceptions.UserCreationException;
import br.com.curso.infrastructure.domain.entity.CustomerEntity;
import br.com.curso.infrastructure.in.config.jwt.JwtUtil;
import br.com.curso.infrastructure.in.mappers.UserMapper;
import br.com.curso.infrastructure.out.repository.CustomerJpaRepository;
import br.com.curso.infrastructure.out.repository.UserJpaRepository;
import br.com.curso.usecases.CreateUserUseCaseImpl;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserService {

    private final CreateUserUseCaseImpl createUserUseCase;

    private final UserMapper userMapper;

    private final UserJpaRepository userJpaRepository;

    private final CustomerJpaRepository customerJpaRepository;

    private final PasswordEncoder securityConfig;

    public UserService(CreateUserUseCaseImpl createUserUseCase, UserMapper userMapper, UserJpaRepository userJpaRepository, CustomerJpaRepository customerJpaRepository, PasswordEncoder securityConfig) {
        this.createUserUseCase = createUserUseCase;
        this.userMapper = userMapper;
        this.userJpaRepository = userJpaRepository;
        this.customerJpaRepository = customerJpaRepository;
        this.securityConfig = securityConfig;
    }

    @Transactional
    public ResponseEntity<?> createUser(User user) throws Exception {

        var userEntity = createUserUseCase.createUser(user);

        var entity = userMapper.toUserEntity(userEntity);

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        var passwordOfEmail = customerJpaRepository.findByEmail(entity.getEmail());

        if (passwordOfEmail.isEmpty()) throw new Exception("Email dont`t exist");

        System.out.println(passwordEncoder.matches(entity.getPassword(), passwordOfEmail.get().getPassword()));
        System.out.println(entity.getPassword());
        System.out.println(passwordOfEmail.get().getPassword());

        if (!passwordEncoder.matches(entity.getPassword(), passwordOfEmail.get().getPassword()))
            throw new InvalidCredentialsException();

        entity.setPassword(securityConfig.encode(entity.getPassword()));

        userJpaRepository.save(entity);

        return ResponseEntity.status(201).body(JwtUtil.generateToken(entity.getEmail()));
    }


}