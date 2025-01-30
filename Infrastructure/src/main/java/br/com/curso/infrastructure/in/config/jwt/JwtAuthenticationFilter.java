package br.com.curso.infrastructure.in.config.jwt;

import br.com.curso.infrastructure.domain.entity.VehicleEntity;
import br.com.curso.infrastructure.in.mappers.VehicleMapper;
import br.com.curso.infrastructure.in.service.VehicleService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;


public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationFilter.class);


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // Se for uma rota pública, continua sem verificar o token
        if (shouldNotFilter(request)) {

            filterChain.doFilter(request, response);
            return;
        }

        // Verifica o token nas rotas protegidas
        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {

            String token = authHeader.substring(7);

            if (JwtUtil.validateToken(token)) {

                filterChain.doFilter(request, response);  // Token válido, segue o fluxo
            } else {

                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);  // Token inválido
            }
        } else {

            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);  // Sem token
        }
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        String path = request.getServletPath();
        // Libera o filtro para rotas de cadastro e login
        return path.equals("/api/v1/user/login") || path.equals("/api/v1/customer/createCustomer");
    }




}