package com.backend.consultorioOdontologico.service.Impl;

import com.backend.consultorioOdontologico.dto.entrada.OdontologoEntradaDto;
import com.backend.consultorioOdontologico.dto.salida.OdontologoSalidaDto;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

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
    void deberiaRegistrarseUnOdontologoDeNombreAlejandro_yRetornarSuId() {

        OdontologoEntradaDto odontologoEntradaDto = new OdontologoEntradaDto("2547DFERD", "Alejandro", "Pereira");
        OdontologoSalidaDto odontologoSalidaDto = odontologoService.registrarOdontologo(odontologoEntradaDto);

        assertNotNull(odontologoSalidaDto);
        assertNotNull(odontologoSalidaDto.getId());
        assertEquals("Alejandro", odontologoSalidaDto.getNombre());

    }

    @Test
    @Order(2)
    void deberiaEliminarseElOdontologoConId1() {

        assertDoesNotThrow(() -> odontologoService.eliminarOdontologo(1L));
    }


    @Test
    @Order(3)
    void deberiaDevolverUnaListaVaciaDeOdontologos() {
        List<OdontologoSalidaDto> odontologos = odontologoService.listarOdontologos();

        assertTrue(odontologos.isEmpty());
    }

    @Test
    @Order(4)
    void deberiaRetornarNullCuandoSeBuscaUnOdontologoPorId() {
        OdontologoSalidaDto odontologoBuscado = odontologoService.buscarOdontologoPorId(1L);

        assertNull(odontologoBuscado);

    }

}
