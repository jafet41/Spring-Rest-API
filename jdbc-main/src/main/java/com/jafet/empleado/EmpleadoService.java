package com.jafet.empleado;

import com.jafet.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {

    private final EmpleadoDao empleadoDao;

    public EmpleadoService(EmpleadoDao empleadoDao) {
        this.empleadoDao = empleadoDao;
    }

    public List<Empleado> getempleados() {
        return empleadoDao.selectempleados();
    }

    public void addNewempleado(Empleado empleado) {
        // TODO: check if empleado exists
        int result = empleadoDao.insertempleado(empleado);
        if (result != 1) {
            throw new IllegalStateException("oops something went wrong");
        }
    }

    public void deleteempleado(Integer id) {
        Optional<Empleado> empleados = empleadoDao.selectempleadoById(id);
        empleados.ifPresentOrElse(empleado -> {
            int result = empleadoDao.deleteempleado(id);
            if (result != 1) {
                throw new IllegalStateException("oops could not delete empleado");
            }
        }, () -> {
            throw new NotFoundException(String.format("empleado with id %s not found", id));
        });
    }

    public Empleado getempleado(int id) {
        return empleadoDao.selectempleadoById(id)
                .orElseThrow(() -> new NotFoundException(String.format("empleado with id %s not found", id)));
    }
}
