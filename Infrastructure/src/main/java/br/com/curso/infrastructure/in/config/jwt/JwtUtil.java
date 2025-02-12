package br.com.curso.infrastructure.in.config.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class JwtUtil {


    private static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private static final long EXPIRATION_TIME = 86400000; // 1 dia em milissegundos


    public static String generateToken(String username) {
        var token = Jwts.builder()
                .setSubject(username)                      // Define o usuário (identificação no token)
                .setIssuedAt(new Date())                   // Data de criação do token
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)) // Expiração
                .signWith(SECRET_KEY, SignatureAlgorithm.HS256)                     // Assina o token com a chave secreta
                .compact();                                // Compacta e retorna o token em formato String


        return token;
    }

    // Valida o token
    public static boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(SECRET_KEY)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Extrai o username do token
    public static String extractUsername(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject(); // Retorna o subject (username)
    }


}