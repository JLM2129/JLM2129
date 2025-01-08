package com.aluraCursos.desafioForoApi.domain;

public class ValidacionException extends RuntimeException {
    public ValidacionException(String mensaje) {

        super(mensaje);
    }
}