CREATE TABLE users (
    id BIGINT IDENTITY PRIMARY KEY,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    role VARCHAR(20) NOT NULL DEFAULT 'USER',
    enabled bit NOT NULL DEFAULT 1,
    account_non_expired bit NOT NULL DEFAULT 1,
    account_non_locked bit NOT NULL DEFAULT 1,
    credentials_non_expired bit NOT NULL DEFAULT 1
);
