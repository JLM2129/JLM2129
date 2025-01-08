package com.aluraCursos.desafioForoApi.controller;

import com.aluraCursos.desafioForoApi.infra.security.JwtUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/api/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        if ("juan.locarno".equals(loginRequest.getUsername()) && "hdzLsXI4nRuNKHLdJj2qB6lf104Jd1SRx+nMahspQyVAU3y6WcUQMMbJ89bg8oH/56lpt8vAE7QXGq/LE9OkHQ==".equals(loginRequest.getPassword())) {
            String token = jwtUtil.generateToken(loginRequest.getUsername());
            return ResponseEntity.ok(new JwtResponse(token, "Clave secreta"));
        }
        return ResponseEntity.status(401).body("Invalid credentials");
    }
}
