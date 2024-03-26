package com.backend.consultorioOdontologico.service;

import com.backend.consultorioOdontologico.dto.entrada.OdontologoEntradaDto;
import com.backend.consultorioOdontologico.dto.salida.OdontologoSalidaDto;
import com.backend.consultorioOdontologico.exceptions.ResourceNotFoundException;

import java.util.List;

public interface IOdontologoService {
    OdontologoSalidaDto registrarOdontologo(OdontologoEntradaDto odontologo);

    List<OdontologoSalidaDto> listarOdontologos();

    OdontologoSalidaDto buscarOdontologoPorId(Long id);

    void eliminarOdontologo(Long id) throws ResourceNotFoundException;

    OdontologoSalidaDto modificarOdontologo(OdontologoEntradaDto odontologoEntradaDto, Long id);

}
