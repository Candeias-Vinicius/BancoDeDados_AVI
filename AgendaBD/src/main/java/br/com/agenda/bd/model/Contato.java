package br.com.agenda.bd.model;

public class Contato {
	
	private Integer id;
	private String nome;
	private String telefone;
	private String celular;
	private Integer idGrupo;
		
	public Contato(String nome, String telefone, String celular, Integer idGrupo) {
		super();
			
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
	public Integer getIdGrupo() {
		return idGrupo;
	}
	public void setIdGrupo(Integer idGrupo) {
		this.idGrupo = idGrupo;
	}
		
	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "\n Contato: " + nome + ", \n Telefone: " + telefone + ", \n Celular: " + celular + "\n";
	}
}
