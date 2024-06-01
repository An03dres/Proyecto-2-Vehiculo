CREATE DATABASE vehiculo;

USE vehiculo;

CREATE TABLE IF NOT EXISTS vehiculo (
    vehiculo_id BIGINT AUTO_INCREMENT,
    color VARCHAR(255),
    marca VARCHAR(255),
    modelo VARCHAR(255),
    placa VARCHAR(255),
    tipo VARCHAR(255),
    PRIMARY KEY (vehiculo_id)
);

COMMIT;


