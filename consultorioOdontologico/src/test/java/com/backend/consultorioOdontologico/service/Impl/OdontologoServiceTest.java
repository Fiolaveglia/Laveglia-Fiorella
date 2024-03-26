package com.backend.consultorioOdontologico.service.Impl;

import com.backend.consultorioOdontologico.dto.entrada.DomicilioEntradaDto;
import com.backend.consultorioOdontologico.dto.entrada.OdontologoEntradaDto;
import com.backend.consultorioOdontologico.dto.entrada.PacienteEntradaDto;
import com.backend.consultorioOdontologico.dto.salida.OdontologoSalidaDto;
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
class OdontologoServiceTest {

    @Autowired
    private OdontologoService odontologoService;

    @Test
    @Order(1)
    void deberiaRegistrarseUnPacienteDeNombreAlejandro_yRetornarSuId() {

        OdontologoEntradaDto odontologoEntradaDto = new OdontologoEntradaDto("2547", "Alejandro", "Pereira");
        OdontologoSalidaDto odontologoSalidaDto = odontologoService.registrarOdontologo(odontologoEntradaDto);

        assertNotNull(odontologoSalidaDto);
        assertNotNull(odontologoSalidaDto.getId());
        assertEquals("Alejandro", odontologoSalidaDto.getNombre());

    }

    @Test
    @Order(2)
    void deberiaEliminarseElPacienteConId1() {

        assertDoesNotThrow(() -> odontologoService.eliminarOdontologo(1L));
    }


    @Test
    @Order(3)
    void deberiaDevolverUnaListaVaciaDePacientes() {
        List<OdontologoSalidaDto> odontologos = odontologoService.listarOdontologos();

        assertTrue(odontologos.isEmpty());
    }

    @Test
    @Order(4)
    void deberiaRetornarNullCuandoSeBuscaUnPacientePorId() {
        OdontologoSalidaDto odontologoBuscado = odontologoService.buscarOdontologoPorId(1L);

        assertNull(odontologoBuscado);

    }

}
