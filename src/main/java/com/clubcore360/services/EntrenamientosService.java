package com.clubcore360.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clubcore360.dto.EntrenamientoDTO;
import com.clubcore360.model.Entrenamiento;
import com.clubcore360.repository.EntrenamientoRepository;

@Service
public class EntrenamientosService {

    @Autowired
    private EntrenamientoRepository entrenamientoRepository;

    public List<EntrenamientoDTO> obtenerEntrenamientos(Long escuelaId) {

        List<Entrenamiento> entrenamientoEntity =
                entrenamientoRepository
                        .findByActivoTrueAndCategoria_Escuela_Id(escuelaId);

        return entrenamientoEntity.stream()
                .map(e -> {
                    EntrenamientoDTO dto = new EntrenamientoDTO();

                    dto.setId(e.getId());
                    dto.setCategoriaId(e.getCategoria().getId());
                    dto.setCategoriaNombre(e.getCategoria().getNombre());
                    dto.setDia(e.getDia());
                    dto.setHoraInicio(e.getHoraInicio().toString());
                    dto.setHoraFin(e.getHoraFin().toString());
                    dto.setSede(e.getSede());
                    dto.setActivo(e.getActivo());

                    return dto;
                })
                .toList();
    }
}