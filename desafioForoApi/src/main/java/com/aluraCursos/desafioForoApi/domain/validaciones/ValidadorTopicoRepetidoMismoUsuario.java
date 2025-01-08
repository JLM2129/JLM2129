package com.aluraCursos.desafioForoApi.domain.validaciones;

import com.aluraCursos.desafioForoApi.domain.topico.DatosRegistroTopico;
import com.aluraCursos.desafioForoApi.domain.topico.TopicoRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ValidadorTopicoRepetidoMismoUsuario {

    @Autowired
    private TopicoRepository repository;

    public void validar(DatosRegistroTopico datos) {
        var topicoRepetido = repository.existsByAutorAndDatos(
                datos.autor(),
                datos.titulo(),
                datos.mensaje(),
                datos.nombreCurso()
        );
        if (topicoRepetido) {
            throw new ValidationException("No puede registrar los mismos datos para el mismo autor");
        }
    }
}


