package com.aluraCursos.desafioForoApi.infra.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public JwtUtil jwtUtil() {
        return new JwtUtil();
    }
}
