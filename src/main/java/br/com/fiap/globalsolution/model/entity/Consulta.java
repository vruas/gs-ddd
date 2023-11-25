package br.com.fiap.globalsolution.model.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Consulta {

	@NotNull
	private Long idConsulta;
	@NotBlank
	private String dataCon;
	@NotBlank
	private String horaCoon;
	@NotBlank
	private String detalhesCon;
	
	public Consulta() {
	}
	
	public Consulta(@NotNull Long idConsulta, @NotBlank String dataCon, @NotBlank String horaCoon,
			@NotBlank String detalhesCon) {
		this.idConsulta = idConsulta;
		this.dataCon = dataCon;
		this.horaCoon = horaCoon;
		this.detalhesCon = detalhesCon;
	}
	
	public Long getIdConsulta() {
		return idConsulta;
	}
	public void setIdConsulta(Long idConsulta) {
		this.idConsulta = idConsulta;
	}
	public String getDataCon() {
		return dataCon;
	}
	public void setDataCon(String dataCon) {
		this.dataCon = dataCon;
	}
	public String getHoraCoon() {
		return horaCoon;
	}
	public void setHoraCoon(String horaCoon) {
		this.horaCoon = horaCoon;
	}
	public String getDetalhesCon() {
		return detalhesCon;
	}
	public void setDetalhesCon(String detalhesCon) {
		this.detalhesCon = detalhesCon;
	}
	
	
	
	
}
