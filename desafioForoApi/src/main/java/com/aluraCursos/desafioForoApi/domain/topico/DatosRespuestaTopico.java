package com.aluraCursos.desafioForoApi.domain.topico;

import java.time.LocalDateTime;

public record DatosRespuestaTopico(  String titulo, String mensaje, LocalDateTime fecha,  String autor, String nombreCurso) {
}
