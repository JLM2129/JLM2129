CREATE TABLE topicos (
    id BIGINT NOT NULL AUTO_INCREMENT,
    id_usuario BIGINT NOT NULL,
    titulo VARCHAR(255) NOT NULL,
    mensaje VARCHAR(255) NOT NULL,
    fecha DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    activo BOOLEAN NOT NULL,
    autor VARCHAR(255) NOT NULL,
    nombre_curso VARCHAR(255) NOT NULL,
    titulo_substr VARCHAR(100) GENERATED ALWAYS AS (LEFT(titulo, 100)) STORED,
    mensaje_substr VARCHAR(100) GENERATED ALWAYS AS (LEFT(mensaje, 100)) STORED,
    nombre_curso_substr VARCHAR(100) GENERATED ALWAYS AS (LEFT(nombre_curso, 100)) STORED,
    PRIMARY KEY (id),
    UNIQUE (autor, id_usuario) -- Restricción única que asegura consistencia de idUsuario para cada autor
);


