/*
DB: SICOPTEST
Tables:

-Empleados
	empleado_id nombre appellido edad 

-Puestos
	nombre_puesto, empleado_id

-Departamentos
	nombre_departamento, empleado_id

-Citas
	fecha_cita, empleado_id

-Usuarios
	user, password
*/

CREATE DATABASE SICOPTEST;
USE SICOPTEST;
CREATE TABLE Empleados (
    empleado_id int NOT NULL AUTO_INCREMENT,
    nombre varchar(255) NOT NULL,
    apellido varchar(255) NOT NULL,
    edad int NOT NULL,
    PRIMARY KEY(empleado_id)
); 

CREATE TABLE Puestos (
	nombre_puesto varchar(255),
    empleado_id int
);

CREATE TABLE Departamentos (
	nombre_departamento varchar(255),
	empleado_id int
);

CREATE TABLE Citas (
	fecha_cita date,
	empleado_id int
);

CREATE TABLE Usuarios (
	usuario varchar(255) NOT NULL,
	password varchar(255) NOT NULL,
	empleado_id int NOT NULL
);


CREATE VIEW MyView AS

SELECT nombre,apellido, edad
FROM Empleados
INNER JOIN Citas ON Empleados.empleado_id=Citas.empleado_id
INNER JOIN Puestos ON Citas.empleado_id=Puestos.empleado_id
INNER JOIN Departamentos ON Puestos.empleado_id= Departamentos.empleado_id
WHERE nombre_puesto='manager' AND nombre_departamento='rrhh' AND fecha_cita BETWEEN '2024-01-01' AND '2029-01-01'
