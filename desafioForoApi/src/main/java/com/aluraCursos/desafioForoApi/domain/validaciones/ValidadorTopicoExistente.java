package com.aluraCursos.desafioForoApi.domain.validaciones;

import com.aluraCursos.desafioForoApi.domain.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorTopicoExistente {

    @Autowired
    private TopicoRepository topicoRepository;

    public void validar(Long id) {
        // Verifica si el tópico con el id proporcionado existe
        boolean existe = topicoRepository.existsById(id);
        if (!existe) {
            throw new IllegalArgumentException("id no se encuentra en la tabla topicos");
        }
    }
}

