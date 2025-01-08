package com.aluraCursos.desafioForoApi.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosRegistroTopico(
        @NotNull
        Long idUsuario,
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,

        @NotBlank
        String autor,
        @NotBlank
        String nombreCurso
) {


}
