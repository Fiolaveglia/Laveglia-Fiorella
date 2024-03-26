package com.backend.consultorioOdontologico.service;


import com.backend.consultorioOdontologico.dto.entrada.TurnoEntradaDto;
import com.backend.consultorioOdontologico.dto.salida.TurnoSalidaDto;
import com.backend.consultorioOdontologico.exceptions.BadRequestException;
import com.backend.consultorioOdontologico.exceptions.ResourceNotFoundException;

import java.util.List;

public interface ITurnoService {
    TurnoSalidaDto registrarTurno(TurnoEntradaDto turnoEntradaDto) throws BadRequestException, ResourceNotFoundException;

    List<TurnoSalidaDto> listarTurnos();

    TurnoSalidaDto buscarTurnoPorId(Long id);

    void eliminarTurno(Long id) throws ResourceNotFoundException;

    TurnoSalidaDto modificarTurno(TurnoEntradaDto turnoEntradaDto, Long id);
}
