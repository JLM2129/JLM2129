package com.aluraCursos.desafioForoApi.domain.topico;

import java.time.LocalDateTime;

public record DatosActualizarTopico(Long id,  String titulo, String mensaje, LocalDateTime fecha, Boolean activo,  String nombreCurso) {
}
