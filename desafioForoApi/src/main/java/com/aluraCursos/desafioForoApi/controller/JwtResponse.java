package com.aluraCursos.desafioForoApi.controller;



public class JwtResponse {
    private String token;
    private String secretKey;

    public JwtResponse(String token, String secretKey) {
        this.token = token;
        this.secretKey = secretKey;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

}
