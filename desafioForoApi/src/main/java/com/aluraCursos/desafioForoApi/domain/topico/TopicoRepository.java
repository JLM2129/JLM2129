package com.aluraCursos.desafioForoApi.domain.topico;

import com.aluraCursos.desafioForoApi.domain.Topico;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TopicoRepository extends JpaRepository<Topico,Long> {
    Page<Topico> findByActivoTrue(Pageable paginacion);
    @Query("""
    select count(t) > 0
    from Topico t
    where t.autor = :autor
    and t.titulo = :titulo
    and t.mensaje = :mensaje
    and t.nombreCurso = :nombreCurso
    and t.activo = true
    """)
    boolean existsByAutorAndDatos(@NotNull String autor, @NotNull String titulo, @NotNull String mensaje, @NotNull String nombreCurso);

    //@Query("SELECT COUNT(t) > 0 FROM Topico t WHERE t.autor = :autor AND t.idUsuario <> :idUsuario")
   // boolean existsByAutorAndIdUsuarioNot(String autor, Long idUsuario);

    boolean existsByIdUsuarioAndAutorNot(Long idUsuario, String autor);


}

