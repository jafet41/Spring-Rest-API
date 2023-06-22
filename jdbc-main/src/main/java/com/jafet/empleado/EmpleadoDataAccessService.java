package com.jafet.empleado;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EmpleadoDataAccessService implements EmpleadoDao {

    private final JdbcTemplate jdbcTemplate;

    public EmpleadoDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Empleado> selectempleados() {
        var sql = """
                SELECT empleado_id, nombre, apellido, edad
                FROM Empleados
                LIMIT 100;
                 """;
        return jdbcTemplate.query(sql, new EmpleadoRowMapper());
    }

    @Override
    public int insertempleado(Empleado empleado) {
        var sql = """
                INSERT INTO Empleados(nombre, apellido,edad)
                VALUES (?, ?, ?);
                 """;
        return jdbcTemplate.update(
                sql,
                empleado.nombre(), empleado.apellido(), empleado.edad()
        );
    }

    @Override
    public int deleteempleado(int empleado_id) {
        var sql = """
                DELETE FROM Empleados   
                WHERE empleado_id = ?
                """;
        return jdbcTemplate.update(sql, empleado_id);
    }

    @Override
    public Optional<Empleado> selectempleadoById(int empleado_id) {
        var sql = """
                SELECT empleado_id, nombre, apellido, edad
                FROM Empleados
                WHERE empleado_id = ?
                 """;
        return jdbcTemplate.query(sql, new EmpleadoRowMapper(), empleado_id)
                .stream()
                .findFirst();
    }

}
