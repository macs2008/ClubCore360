package com.clubcore360.controller;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.clubcore360.dto.EntrenamientoDTO;
import com.clubcore360.dto.EscuelaSlugResponse;
import com.clubcore360.dto.EstadisticasDTO;
import com.clubcore360.model.Entrenamiento;
import com.clubcore360.model.Partido;
import com.clubcore360.services.EntrenamientosService;
import com.clubcore360.services.Estadisticas;
import com.clubcore360.services.ProximosPartidos;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/api")
public class EscuelaController {

	
	@Autowired
	private ProximosPartidos proximosPartidos;
	
	@Autowired
	private Estadisticas estadisticas;
	
	@Autowired
	private EntrenamientosService entrenamientosService;
	
	
    @GetMapping(value = "/escuela", produces = MediaType.APPLICATION_JSON_VALUE)
    public EscuelaSlugResponse getEscuela(HttpServletRequest request) {
        String host = request.getHeader("Host");
        String slug = parseSlugFromHost(host);
        return new EscuelaSlugResponse(slug);
    }

    @GetMapping(value = "/{slug}", produces = MediaType.APPLICATION_JSON_VALUE)
    public EscuelaSlugResponse getEscuelaPorSlug(@PathVariable("slug") String slug) {
        return new EscuelaSlugResponse(slug);
    }

    private String parseSlugFromHost(String host) {
        if (host == null || host.isBlank()) {
            return "koyotes";
        }

        String hostOnly = host.split(":")[0].toLowerCase(Locale.ROOT).trim();
        if (hostOnly.equals("localhost")) {
            return "koyotes";
        }

        String[] parts = hostOnly.split("\\.");
        if (parts.length >= 2 && parts[parts.length - 1].equals("com")) {
            return parts[parts.length - 2];
        }

        return "koyotes";
    }
    @GetMapping("/proximos/{escuelaId}")
    public List<Partido> obtenerProximos(@PathVariable("escuelaId") Long escuelaId) {
        return proximosPartidos.obtenerProximos(escuelaId);
    }
    
    @GetMapping("/estadisticas/{escuelaId}")
    public List<EstadisticasDTO>  estadisticas(@PathVariable("escuelaId") Long escuelaId) {
        return estadisticas.calcularPorEquipo(escuelaId);
    }
    


    @GetMapping("/entrenamientos/{escuelaId}")
    public List<EntrenamientoDTO> obtenerEntrenamientos(@PathVariable("escuelaId") Long escuelaId) {

        return entrenamientosService.obtenerEntrenamientos(escuelaId);
    }
    
    
}