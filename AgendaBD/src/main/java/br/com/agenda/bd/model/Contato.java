package br.com.agenda.bd.model;

import java.util.Objects;

import jakarta.annotation.Generated;

public class Contato {
	
	private Integer id;
	private String nome;
	private String telefone;
	private String celular;
	private Integer idGrupo;
		
	public Contato(Integer id, String nome, String telefone, String celular, Integer idGrupo) {
		super();
		
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.celular = celular;
		this.idGrupo = idGrupo;
	}
	
	public Contato() {
		super();
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdGrupo() {
		return idGrupo;
	}
	public void setIdGrupo(Integer idGrupo) {
		this.idGrupo = idGrupo;
	}
		
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Contato)) {
			return false;
		}
		Contato other = (Contato) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Contato [id=" + id + ", nome=" + nome + ", telefone=" + telefone + ", celular=" + celular + ", idGrupo="
				+ idGrupo + "]";
	}
}
