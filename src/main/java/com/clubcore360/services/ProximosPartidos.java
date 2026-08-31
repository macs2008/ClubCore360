package com.clubcore360.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clubcore360.model.Partido;
import com.clubcore360.repository.PartidoRepository;

@Service
public class ProximosPartidos {

	@Autowired
	private PartidoRepository partidoRepository;

	public List<Partido> obtenerProximos(Long escuelaId) {

		List<Partido> prueba = partidoRepository.findByEscuelaIdAndFechaGreaterThanEqualAndActivoTrue(escuelaId, LocalDate.now());
		
		System.out.println(prueba);
		
		return prueba;
	}
}
