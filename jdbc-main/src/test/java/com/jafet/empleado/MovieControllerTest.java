package com.jafet.empleado;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;

class MovieControllerTest {

    @Mock
    private EmpleadoService movieService;

    private EmpleadoController underTest;

    @BeforeEach
    void setUp() {
        underTest = new EmpleadoController(movieService);
    }
}