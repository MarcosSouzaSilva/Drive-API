package br.com.curso.infrastructure.in;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Main {

    public static PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();


        String s = "123";
        var passwordEncoder = new BCryptPasswordEncoder();

        var d = passwordEncoder.encode(s);

        // Usando o método correto para verificar
        boolean matches = passwordEncoder.matches(s, d);

        System.out.println(s);
        System.out.println(d);
        System.out.println(matches);



    }
}
