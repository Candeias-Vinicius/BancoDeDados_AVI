package br.com.agenda.bd.model;


public class Grupo {

	private Integer id;
	private String nome;
	
	public Grupo(String nome) {
		
		this.nome = nome;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
