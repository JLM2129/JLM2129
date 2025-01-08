package com.aluraCursos.desafioForoApi.domain.validaciones;

import com.aluraCursos.desafioForoApi.domain.topico.DatosRegistroTopico;
import com.aluraCursos.desafioForoApi.domain.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorIdUsuarioDiferente {

    @Autowired
    private TopicoRepository repository;

    public void validar(DatosRegistroTopico datos) {
        // Verificar si el idUsuario ya está asociado a un autor diferente
        boolean existeAutorDiferente = repository.existsByIdUsuarioAndAutorNot(datos.idUsuario(), datos.autor());
        if (existeAutorDiferente) {
            throw new IllegalArgumentException("El idUsuario ya está asociado a un autor diferente.");
        }
    }
}
