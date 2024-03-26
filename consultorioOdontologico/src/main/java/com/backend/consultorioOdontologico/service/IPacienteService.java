package com.backend.consultorioOdontologico.service;


import com.backend.consultorioOdontologico.dto.entrada.PacienteEntradaDto;
import com.backend.consultorioOdontologico.dto.salida.PacienteSalidaDto;
import com.backend.consultorioOdontologico.exceptions.ResourceNotFoundException;

import java.util.List;

public interface IPacienteService {
    PacienteSalidaDto registrarPaciente(PacienteEntradaDto paciente);

    List<PacienteSalidaDto> listarPacientes();

    PacienteSalidaDto buscarPacientePorId(Long id);

    void eliminarPaciente(Long id) throws ResourceNotFoundException;

    PacienteSalidaDto modificarPaciente(PacienteEntradaDto pacienteEntradaDto, Long id) throws ResourceNotFoundException;
}
