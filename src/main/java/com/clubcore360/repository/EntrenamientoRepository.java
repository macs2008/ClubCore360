package com.clubcore360.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.clubcore360.model.Entrenamiento;

public interface EntrenamientoRepository extends JpaRepository<Entrenamiento, Long> {

	List<Entrenamiento> findByActivoTrueAndCategoria_Escuela_Id(Long escuelaId);
}