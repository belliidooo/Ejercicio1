-- ============================================
-- BASE DE DATOS: NOMINAS
-- ============================================

DROP DATABASE IF EXISTS nominas;
CREATE DATABASE nominas
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_general_ci;

USE nominas;

-- ============================================
-- TABLA: empleados
-- ============================================

CREATE TABLE empleados (
    dni VARCHAR(20) NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    sexo CHAR(1) NOT NULL,
    categoria INT NOT NULL,
    anyos INT NOT NULL,

    CONSTRAINT pk_empleados PRIMARY KEY (dni),
    CONSTRAINT chk_empleados_categoria CHECK (categoria BETWEEN 1 AND 10),
    CONSTRAINT chk_empleados_anyos CHECK (anyos >= 0)
);

-- ============================================
-- TABLA: nominas
-- ============================================

CREATE TABLE nominas (
    dni VARCHAR(20) NOT NULL,
    sueldo INT NOT NULL,

    CONSTRAINT pk_nominas PRIMARY KEY (dni),
    CONSTRAINT fk_nominas_empleados
        FOREIGN KEY (dni)
        REFERENCES empleados(dni)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT chk_nominas_sueldo CHECK (sueldo >= 0)
);

-- ============================================
-- DATOS INICIALES
-- ============================================

INSERT INTO empleados (dni, nombre, sexo, categoria, anyos)
VALUES
    ('32000032G', 'James Cosling', 'M', 9, 7),
    ('32000031R', 'Ada Lovelace', 'F', 1, 1);

INSERT INTO nominas (dni, sueldo)
VALUES
    ('32000032G', 245000),
    ('32000031R', 55000);

-- ============================================
-- COMPROBACIONES
-- ============================================

SELECT * FROM empleados;

SELECT * FROM nominas;

SELECT
    e.nombre,
    e.dni,
    e.sexo,
    e.categoria,
    e.anyos,
    n.sueldo
FROM empleados e
INNER JOIN nominas n ON e.dni = n.dni;
