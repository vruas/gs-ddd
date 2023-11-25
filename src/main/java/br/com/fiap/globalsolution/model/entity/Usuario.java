package br.com.fiap.globalsolution.model.entity;

import jakarta.validation.constraints.NotBlank;

public class Usuario {
	
	@NotBlank
	private String nome;
	@NotBlank
	private String cpf;
	@NotBlank
	private String email;
	@NotBlank
	private String senha;

	public Usuario() {
	
	}

	public Usuario(@NotBlank String nome, @NotBlank String cpf, @NotBlank String email, @NotBlank String senha) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	

}
