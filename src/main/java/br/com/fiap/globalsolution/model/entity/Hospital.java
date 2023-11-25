package br.com.fiap.globalsolution.model.entity;

public class Hospital {
	
	private Long idHospital;
	private String nome;
	private String endereco;
	
	
	public Hospital() {
	}
	
	public Hospital(Long idHospital, String nome, String endereco) {
		this.idHospital = idHospital;
		this.nome = nome;
		this.endereco = endereco;
	}
	
	public Long getIdHospital() {
		return idHospital;
	}
	public void setIdHospital(Long idHospital) {
		this.idHospital = idHospital;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
	

}
