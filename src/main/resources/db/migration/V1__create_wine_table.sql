CREATE TABLE wine (
    id BIGINT IDENTITY PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    bodega VARCHAR(255),
    tipo VARCHAR(100),
    precio DECIMAL(10, 2),
    descripcion VARCHAR(1000),
    imagen_url VARCHAR(500)
);
