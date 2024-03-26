package com.backend.consultorioOdontologico.controller;

import com.backend.consultorioOdontologico.dto.entrada.TurnoEntradaDto;
import com.backend.consultorioOdontologico.dto.salida.TurnoSalidaDto;
import com.backend.consultorioOdontologico.exceptions.BadRequestException;
import com.backend.consultorioOdontologico.exceptions.ResourceNotFoundException;
import com.backend.consultorioOdontologico.service.ITurnoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    private ITurnoService turnoService;

    public TurnoController(ITurnoService turnoService) {
        this.turnoService = turnoService;
    }

    //POST
    @PostMapping("/registrar")
    public ResponseEntity<TurnoSalidaDto> registrarPaciente(@RequestBody @Valid TurnoEntradaDto turnoEntradaDto) throws BadRequestException, ResourceNotFoundException {
        return new ResponseEntity<>(turnoService.registrarTurno(turnoEntradaDto), HttpStatus.CREATED);
    }

}
