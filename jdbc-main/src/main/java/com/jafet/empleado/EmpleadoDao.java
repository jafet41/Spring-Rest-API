package com.jafet.empleado;

import java.util.List;
import java.util.Optional;

public interface EmpleadoDao {
    List<Empleado> selectempleados();
    int insertempleado(Empleado empleado);
    int deleteempleado(int empleado_id);
    Optional<Empleado> selectempleadoById(int empleado_id);
    // TODO: Update
}
