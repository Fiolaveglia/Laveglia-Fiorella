package com.backend.consultorioOdontologico.service.Impl;

import com.backend.consultorioOdontologico.dto.entrada.TurnoEntradaDto;
import com.backend.consultorioOdontologico.dto.salida.DomicilioSalidaDto;
import com.backend.consultorioOdontologico.dto.salida.OdontologoSalidaDto;
import com.backend.consultorioOdontologico.dto.salida.PacienteSalidaDto;
import com.backend.consultorioOdontologico.dto.salida.TurnoSalidaDto;
import com.backend.consultorioOdontologico.entity.Domicilio;
import com.backend.consultorioOdontologico.entity.Odontologo;
import com.backend.consultorioOdontologico.entity.Paciente;
import com.backend.consultorioOdontologico.entity.Turno;
import com.backend.consultorioOdontologico.exceptions.BadRequestException;
import com.backend.consultorioOdontologico.repository.TurnoRepository;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestPropertySource(locations = "classpath:application-test.properties")
class TurnoServiceTest {

    @InjectMocks
    private TurnoService turnoService;

    @Mock
    private PacienteService pacienteService;

    @Mock
    private OdontologoService odontologoService;

    @Mock
    private TurnoRepository turnoRepository;

    @Spy
    private ModelMapper modelMapper;

    @Test
    @Order(1)
    public void deberiaCrearTurno() throws BadRequestException {
        when(pacienteService.buscarPacientePorId(1L)).thenReturn(new PacienteSalidaDto(1L, "nombre", "apellido", 1234, LocalDate.now().plusDays(1), new DomicilioSalidaDto(1L, "calle", 1234, "localidad", "provincia")));
        when(odontologoService.buscarOdontologoPorId(1L)).thenReturn(new OdontologoSalidaDto(1L, "matricula", "nombre", "apellido"));
        when(turnoRepository.save(any())).thenReturn(new Turno(1L, new Odontologo(1L, "matricula", "nombre", "apellido"), new Paciente(1L, "nombre", "apellido", 1234, LocalDate.now().plusDays(1), new Domicilio(1L, "calle", 1234, "localidad", "provincia")), LocalDateTime.now().plusDays(1)));
        TurnoEntradaDto turnoDto = new TurnoEntradaDto(1L, 1L, LocalDateTime.now().plusDays(1));
        TurnoSalidaDto turnoCreado = turnoService.registrarTurno(turnoDto);

        assertNotNull(turnoCreado.getId());
    }

    @Test
    @Order(2)
    public void deberiaBuscarTurnoPorIdInexistenteYRetornarNull(){
        when(turnoRepository.findById(1L)).thenReturn(Optional.empty());
        TurnoSalidaDto turnoEncontrado = turnoService.buscarTurnoPorId(1L);

        assertNull(turnoEncontrado);
    }

    @Test
    @Order(3)
    void deberiaRetornarListaVaciaCuandoSeListanLosOdontologosYNoExisteNinguno() {
        when(turnoRepository.findAll()).thenReturn(List.of());
        List<TurnoSalidaDto> turno = turnoService.listarTurnos();

        assertTrue(turno.isEmpty());
}
}



