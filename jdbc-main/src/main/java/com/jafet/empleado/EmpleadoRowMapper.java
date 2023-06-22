package com.jafet.empleado;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class EmpleadoRowMapper implements RowMapper<Empleado> {
    @Override
    public Empleado mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Empleado(
                resultSet.getInt("empleado_id"),
                resultSet.getString("nombre"),
                resultSet.getString("apellido"),
                resultSet.getInt("edad")
        );
    }
}
