package com.aluraCursos.desafioForoApi.domain;

import com.aluraCursos.desafioForoApi.domain.topico.DatosActualizarTopico;
import com.aluraCursos.desafioForoApi.domain.topico.DatosRegistroTopico;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;


import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "topicos")
@Entity(name = "Topico")
@Getter

@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_usuario", nullable = false) // Corrige el nombre de la columna
    private Long idUsuario;

    @Column(nullable = false, unique = true)
    private String titulo;

    @Column(nullable = false)
    private String mensaje;

    @NotNull(message = "La fecha no puede ser nula")
    @Column(nullable = false)
    private LocalDateTime fecha;

    @Column(nullable = false)
    private Boolean activo;

    @Column(nullable = false)
    private String autor;

    @Column(name = "nombre_curso", nullable = false) // Corrige el nombre de la columna
    private String nombreCurso;


    public Topico(DatosRegistroTopico datosRegistroTopico) {

        this.idUsuario = datosRegistroTopico.idUsuario() != null ? datosRegistroTopico.idUsuario() : 0L;
        this.titulo= datosRegistroTopico.titulo();
        this.mensaje= datosRegistroTopico.mensaje();

        this.fecha=LocalDateTime.now();
        this.activo=true;
        this.autor= datosRegistroTopico.autor();
        this.nombreCurso= datosRegistroTopico.nombreCurso();
    }
    public void actualizarDatos(DatosActualizarTopico datosActualizarTopico) {

        if (datosActualizarTopico.titulo()!= null) {
            this.titulo = datosActualizarTopico.titulo();
        }
        if (datosActualizarTopico.mensaje()!= null) {
            this.mensaje = datosActualizarTopico.mensaje();
        }

        if (datosActualizarTopico.nombreCurso()!= null) {
            this.nombreCurso = datosActualizarTopico.nombreCurso();
        }
    }
    public Topico() {
    }
    public Long getIdUsuario() {
        return idUsuario;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public @NotNull(message = "La fecha no debe ser nula") LocalDateTime getFecha() {
        return fecha;
    }

    public Boolean getActivo() {
        return activo;
    }

    public String getAutor() {
        return autor;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public Long getId() {return id;}

    public void desactivarTopico() {this.activo=false;
    }

    public void setActivo(boolean b) {
    }
}
