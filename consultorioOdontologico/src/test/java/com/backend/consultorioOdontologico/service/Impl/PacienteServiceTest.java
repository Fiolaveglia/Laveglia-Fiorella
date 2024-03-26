package com.backend.consultorioOdontologico.service.Impl;

import com.backend.consultorioOdontologico.dto.entrada.DomicilioEntradaDto;
import com.backend.consultorioOdontologico.dto.entrada.PacienteEntradaDto;
import com.backend.consultorioOdontologico.dto.salida.PacienteSalidaDto;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestPropertySource(locations = "classpath:application-test.properties")
class PacienteServiceTest {

    @Autowired
    private PacienteService pacienteService;

    @Test
    @Order(1)
    void deberiaRegistrarseUnPacienteDeNombreMario_yRetornarSuId() {
        PacienteEntradaDto pacienteEntradaDto = new PacienteEntradaDto("Mario", "Gonzalez", 98665547, LocalDate.of(2024, 5, 14), new DomicilioEntradaDto("Calle", 2644, "Localidad", "Provincia"));
        PacienteSalidaDto pacienteSalidaDto = pacienteService.registrarPaciente(pacienteEntradaDto);

        assertNotNull(pacienteSalidaDto);
        assertNotNull(pacienteSalidaDto.getId());
        assertEquals("Mario", pacienteSalidaDto.getNombre());

    }

    @Test
    @Order(2)
    void deberiaEliminarseElPacienteConId1() {

        assertDoesNotThrow(() -> pacienteService.eliminarPaciente(1L));
    }


    @Test
    @Order(3)
    void deberiaDevolverUnaListaVaciaDePacientes() {
        List<PacienteSalidaDto> pacientes = pacienteService.listarPacientes();

        assertTrue(pacientes.isEmpty());
    }

    @Test
    @Order(4)
    void deberiaRetornarNullCuandoSeBuscaUnPacientePorId() {
        PacienteSalidaDto pacienteBuscado = pacienteService.buscarPacientePorId(1L);

        assertNull(pacienteBuscado);

    }

}