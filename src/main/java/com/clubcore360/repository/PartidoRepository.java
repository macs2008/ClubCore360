package com.clubcore360.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clubcore360.model.Partido;

public interface PartidoRepository extends JpaRepository<Partido, Long> {

    List<Partido> findByEscuelaIdAndFechaGreaterThanEqualAndActivoTrue(
        Long escuelaId, LocalDate fecha
    );

    
    List<Partido> findByEquipoLocalIdOrEquipoVisitanteId(Long localId, Long visitanteId);
}
