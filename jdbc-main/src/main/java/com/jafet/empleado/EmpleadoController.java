package com.jafet.empleado;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/empleados")
public class EmpleadoController {

    private final EmpleadoService empleadoService;

    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @GetMapping
    public List<Empleado> listempleados() {
        return empleadoService.getempleados();
    }

    @GetMapping("{id}")
    public Empleado getempleadoId(@PathVariable("id") Integer id) {
        return empleadoService.getempleado(id);
    }

    @PostMapping
    public void addempleado(@RequestBody Empleado empleado) {
        empleadoService.addNewempleado(empleado);
    }

    @DeleteMapping("{id}")
    public void deleteempleado(@PathVariable("id") Integer id) {
        empleadoService.deleteempleado(id);
    }

}
