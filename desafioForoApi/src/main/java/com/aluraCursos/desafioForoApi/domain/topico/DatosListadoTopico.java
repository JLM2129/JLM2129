package com.aluraCursos.desafioForoApi.domain.topico;

import com.aluraCursos.desafioForoApi.domain.Topico;

import java.time.LocalDateTime;

public record DatosListadoTopico(Long id, String titulo, String mensaje, LocalDateTime fecha, Boolean activo, String autor, String nombreCurso) {
    public DatosListadoTopico(Topico topico) {
        this(topico.getId(),  topico.getTitulo(), topico.getMensaje(), topico.getFecha(), topico.getActivo(), topico.getAutor(), topico.getNombreCurso());

    }
}
