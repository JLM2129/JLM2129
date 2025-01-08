package com.aluraCursos.desafioForoApi.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public ResponseEntity<?> handleError() {
        return ResponseEntity.status(500).body("Se produjo un error inesperado. Por favor, intente nuevamente.");
    }
}


