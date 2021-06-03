package br.com.agenda.bd.model;

import java.util.Objects;

public class Contato {
	
	private Integer id;
	private String nome;
	private String telefone;
	private String celular;
	private TipoGrupoEnum Nomegrupo;
		
	public Contato(String nome, String telefone, String celular, TipoGrupoEnum grupo) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.celular = celular;
		this.Nomegrupo = grupo;
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

	public TipoGrupoEnum getGrupo() {
		return Nomegrupo;
	}
	public void setGrupo(TipoGrupoEnum grupo) {
		this.Nomegrupo = grupo;
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
}
