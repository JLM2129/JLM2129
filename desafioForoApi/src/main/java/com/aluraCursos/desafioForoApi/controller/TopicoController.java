package com.aluraCursos.desafioForoApi.controller;

import com.aluraCursos.desafioForoApi.domain.Topico;
import com.aluraCursos.desafioForoApi.domain.topico.*;
import com.aluraCursos.desafioForoApi.domain.validaciones.ValidadorIdUsuarioDiferente;
import com.aluraCursos.desafioForoApi.domain.validaciones.ValidadorTopicoExistente;
import com.aluraCursos.desafioForoApi.domain.validaciones.ValidadorTopicoRepetidoMismoUsuario;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private ValidadorTopicoRepetidoMismoUsuario validadorTopicoRepetido;

    @Autowired
    private ValidadorIdUsuarioDiferente validadorIdUsuarioDiferente;

    @Autowired
    private ValidadorTopicoExistente validadorTopicoExistente;

    /**
     * Registrar un nuevo tópico con validaciones.
     */
    @PostMapping
    public ResponseEntity<DatosRespuestaTopico> registrarTopico(
            @RequestBody @Valid DatosRegistroTopico datosRegistroTopico,
            UriComponentsBuilder uriComponentsBuilder) {

        // Validar reglas de negocio
        validadorTopicoRepetido.validar(datosRegistroTopico);
        validadorIdUsuarioDiferente.validar(datosRegistroTopico);

        // Crear y guardar el tópico
        Topico topico = new Topico(datosRegistroTopico);
        topicoRepository.save(topico);

        // Construir respuesta
        URI location = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(location).body(
                new DatosRespuestaTopico(topico.getTitulo(), topico.getMensaje(), topico.getFecha(), topico.getAutor(), topico.getNombreCurso())
        );
    }

    /**
     * Obtener un listado paginado de tópicos activos.
     */
    @Autowired
    private PagedResourcesAssembler<DatosListadoTopico> pagedResourcesAssembler;

    @GetMapping
    public ResponseEntity<?> listadoTopicos(@PageableDefault(size = 4) Pageable paginacion) {
        Page<Topico> topicos = topicoRepository.findByActivoTrue(paginacion);
        Page<DatosListadoTopico> dtoPage = topicos.map(DatosListadoTopico::new);

        return ResponseEntity.ok(pagedResourcesAssembler.toModel(dtoPage));
    }


    /**
     * Actualizar un tópico existente.
     */
    @PutMapping
    @Transactional
    public ResponseEntity<DatosRespuestaTopico> actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico) {
        Topico topico = topicoRepository.getReferenceById(datosActualizarTopico.id());
        topico.actualizarDatos(datosActualizarTopico);
        return ResponseEntity.ok(new DatosRespuestaTopico(
                topico.getTitulo(), topico.getMensaje(), topico.getFecha(), topico.getAutor(), topico.getNombreCurso()
        ));
    }


    /**
     * Eliminar un tópico (desactivarlo lógicamente).
     */


    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> eliminarTopico(@PathVariable Long id) {
        try {
            // Validar que el id del tópico existe
            validadorTopicoExistente.validar(id);

            // Si el tópico existe, proceder con la desactivación
            Topico topico = topicoRepository.getReferenceById(id);
            topico.desactivarTopico();

            // Retorna el mensaje de éxito con código 200 OK
            return ResponseEntity.ok("Registro borrado con éxito");

        }catch(IllegalArgumentException e){
                // En caso de que no se encuentre el tópico, devolver el mensaje de error
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
            }

    }
}


