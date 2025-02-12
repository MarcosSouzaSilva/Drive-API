package br.com.curso.infrastructure.in.config.security;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
@SecurityScheme(name = SecurityConfigs.SECURITY, type = SecuritySchemeType.HTTP, bearerFormat = "JWT", scheme = "bearer")
public class SecurityConfigs {

    public static final String SECURITY = "bearerAuth";

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        return httpSecurity
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers(
                            "/api/v1/customer/**",
                            "/api/v1/user/**",
                            "/api/v1/user/login",
                            "/api/v1/vehicle/createVehicle",
                            "/v3/api-docs/**",
                            "/swagger-ui/**",
                            "/swagger-ui.html",
                            "/api/v1/customer/createCustomer"
                    ).permitAll();
                    auth.anyRequest().authenticated();
                })
                .httpBasic(AbstractHttpConfigurer::disable)
                .sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .csrf(AbstractHttpConfigurer::disable)
                //.addFilterBefore(new JwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                .build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }

}