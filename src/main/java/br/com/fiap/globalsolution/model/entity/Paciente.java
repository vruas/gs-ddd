package br.com.fiap.globalsolution.model.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Paciente {
	
	@NotNull
	private Long id;
	@NotBlank
	private String nomeCompleto;
	@NotBlank
	private String dataNasci;
	@NotBlank
	private String genero;
	@NotBlank
	private String endereco;
	@NotBlank
	private String email;
	@NotBlank
	private String especMed;
	
	
	public Paciente() {

	}

	public Paciente(@NotNull Long id, @NotBlank String nomeCompleto, @NotBlank String dataNasci,
			@NotBlank String genero, @NotBlank String endereco, @NotBlank String email, @NotBlank String especMed) {
		this.id = id;
		this.nomeCompleto = nomeCompleto;
		this.dataNasci = dataNasci;
		this.genero = genero;
		this.endereco = endereco;
		this.email = email;
		this.especMed = especMed;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getDataNasci() {
		return dataNasci;
	}

	public void setDataNasci(String dataNasci) {
		this.dataNasci = dataNasci;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
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

	public String getEspecMed() {
		return especMed;
	}

	public void setEspecMed(String especMed) {
		this.especMed = especMed;
	}
	
	
	

}
