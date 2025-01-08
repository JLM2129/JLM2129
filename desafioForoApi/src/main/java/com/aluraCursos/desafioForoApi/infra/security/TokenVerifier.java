package com.aluraCursos.desafioForoApi.infra.security;
import io.jsonwebtoken.Jwts;

import java.util.Base64;

public class TokenVerifier {

    // Codifica la clave secreta en Base64 (debe ser la misma en ambos lados)
    private static final String JWT_SECRET = Base64.getEncoder().encodeToString("jwtSecret".getBytes());

    public static void verificarToken(String token) {
        try {
            // Verifica que el token sea válido
            Jwts.parserBuilder()
                    .setSigningKey(JWT_SECRET.getBytes())  // Establece la clave secreta para verificar la firma
                    .build()
                    .parseClaimsJws(token);  // Intenta decodificar el token

            System.out.println("Token válido");
        } catch (Exception e) {
            System.out.println("Error al verificar el token: " + e.getMessage());
        }
    }
}
