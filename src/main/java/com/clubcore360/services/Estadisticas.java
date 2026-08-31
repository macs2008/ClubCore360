package com.clubcore360.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clubcore360.dto.EstadisticasDTO;
import com.clubcore360.model.Partido;
import com.clubcore360.repository.PartidoRepository;

@Service
public class Estadisticas {
	@Autowired
    private PartidoRepository partidoRepository;

	public List<EstadisticasDTO> calcularPorEquipo(Long equipoId) {

	    List<Partido> partidos = partidoRepository
	            .findByEquipoLocalIdOrEquipoVisitanteId(equipoId, equipoId);

	    Map<Long, EstadisticasDTO> mapa = new HashMap<>();

	    for (Partido p : partidos) {

	        if (p.getPuntosLocal() == null || p.getPuntosVisitante() == null) {
	            continue;
	        }

	        Long categoriaId = p.getCategoria().getId();

	        // 🔥 crear DTO por categoría si no existe
	        mapa.putIfAbsent(categoriaId, new EstadisticasDTO());

	        EstadisticasDTO dto = mapa.get(categoriaId);

	        dto.setCategoriaId(categoriaId);
	        dto.setCategoriaNombre(p.getCategoria().getNombre());

	        boolean esLocal = p.getEquipoLocal().getId().equals(equipoId);

	        int misPuntos = esLocal ? p.getPuntosLocal() : p.getPuntosVisitante();
	        int rivalPuntos = esLocal ? p.getPuntosVisitante() : p.getPuntosLocal();

	        dto.setPartidosJugados(dto.getPartidosJugados() + 1);
	        dto.setPuntosAFavor(dto.getPuntosAFavor() + misPuntos);
	        dto.setPuntosEnContra(dto.getPuntosEnContra() + rivalPuntos);

	        if (misPuntos > rivalPuntos) {
	            dto.setVictorias(dto.getVictorias() + 1);
	        } else if (misPuntos < rivalPuntos) {
	            dto.setDerrotas(dto.getDerrotas() + 1);
	        } else {
	            dto.setEmpates(dto.getEmpates() + 1);
	        }
	    }

	    // 🔥 calcular promedios
	    for (EstadisticasDTO dto : mapa.values()) {

	        int jugados = dto.getPartidosJugados();

	        dto.setDiferenciaPuntos(dto.getPuntosAFavor() - dto.getPuntosEnContra());

	        dto.setPromedioPuntos(
	            jugados > 0 ? (double) dto.getPuntosAFavor() / jugados : 0
	        );
	    }

	    return new ArrayList<>(mapa.values());
	}
}
