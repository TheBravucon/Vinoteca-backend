CREATE TABLE bodega (
    id BIGINT IDENTITY PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    descripcion VARCHAR(1000),
    ubicacion VARCHAR(255),
    pais VARCHAR(100),
    imagen_url VARCHAR(500),
    fecha_creacion TIMESTAMP NOT NULL
);
