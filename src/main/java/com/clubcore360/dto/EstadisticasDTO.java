package com.clubcore360.dto;

public class EstadisticasDTO {

	private Long equipoId;
	private String nombreEquipo;

	private Long categoriaId;
	private String categoriaNombre;

	private int partidosJugados;
	private int victorias;
	private int derrotas;
	private int empates;

	private int puntosAFavor;
	private int puntosEnContra;
	private int diferenciaPuntos;

	private double promedioPuntos;

	private String ultimoResultado; // "W", "L", "D"

	public Long getEquipoId() {
		return equipoId;
	}

	public void setEquipoId(Long equipoId) {
		this.equipoId = equipoId;
	}

	public String getNombreEquipo() {
		return nombreEquipo;
	}

	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}

	public Long getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(Long categoriaId) {
		this.categoriaId = categoriaId;
	}

	public String getCategoriaNombre() {
		return categoriaNombre;
	}

	public void setCategoriaNombre(String categoriaNombre) {
		this.categoriaNombre = categoriaNombre;
	}

	public int getPartidosJugados() {
		return partidosJugados;
	}

	public void setPartidosJugados(int partidosJugados) {
		this.partidosJugados = partidosJugados;
	}

	public int getVictorias() {
		return victorias;
	}

	public void setVictorias(int victorias) {
		this.victorias = victorias;
	}

	public int getDerrotas() {
		return derrotas;
	}

	public void setDerrotas(int derrotas) {
		this.derrotas = derrotas;
	}

	public int getEmpates() {
		return empates;
	}

	public void setEmpates(int empates) {
		this.empates = empates;
	}

	public int getPuntosAFavor() {
		return puntosAFavor;
	}

	public void setPuntosAFavor(int puntosAFavor) {
		this.puntosAFavor = puntosAFavor;
	}

	public int getPuntosEnContra() {
		return puntosEnContra;
	}

	public void setPuntosEnContra(int puntosEnContra) {
		this.puntosEnContra = puntosEnContra;
	}

	public int getDiferenciaPuntos() {
		return diferenciaPuntos;
	}

	public void setDiferenciaPuntos(int diferenciaPuntos) {
		this.diferenciaPuntos = diferenciaPuntos;
	}

	public double getPromedioPuntos() {
		return promedioPuntos;
	}

	public void setPromedioPuntos(double promedioPuntos) {
		this.promedioPuntos = promedioPuntos;
	}

	public String getUltimoResultado() {
		return ultimoResultado;
	}

	public void setUltimoResultado(String ultimoResultado) {
		this.ultimoResultado = ultimoResultado;
	}

}
