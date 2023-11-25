package br.com.fiap.globalsolution.model.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Medico {

	@NotNull
	private Long idMed;
	@NotBlank
	private String nomeCompleto;
	@NotBlank
	private String especMed;
	@NotBlank
	private String endereco;
	@NotBlank
	private String email;
	@NotBlank
	private String disponibilidade;
	
	
	public Medico() {
	}
	
	public Medico(@NotNull Long idMed, @NotBlank String nomeCompleto, @NotBlank String especMed,
			@NotBlank String endereco, @NotBlank String email, @NotBlank String disponibilidade) {
		this.idMed = idMed;
		this.nomeCompleto = nomeCompleto;
		this.especMed = especMed;
		this.endereco = endereco;
		this.email = email;
		this.disponibilidade = disponibilidade;
	}
	
	public Long getIdMed() {
		return idMed;
	}
	public void setIdMed(Long idMed) {
		this.idMed = idMed;
	}
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	public String getEspecMed() {
		return especMed;
	}
	public void setEspecMed(String especMed) {
		this.especMed = especMed;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDisponibilidade() {
		return disponibilidade;
	}
	public void setDisponibilidade(String disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

	
}
