package br.com.agenda.bd.model;

import java.util.List;

public class GrupoContato {
	private TipoGrupoEnum tipoGrupo;
	private List<Contato> contatos;
	
	public GrupoContato(TipoGrupoEnum tipoGrupo, List<Contato> contatos) {
		super();
		this.tipoGrupo = tipoGrupo;
		this.contatos = contatos;
	}
	public TipoGrupoEnum getTipoGrupo() {
		return tipoGrupo;
	}
	public void setTipoGrupo(TipoGrupoEnum tipoGrupo) {
		this.tipoGrupo = tipoGrupo;
	}
	public List<Contato> getContatos() {
		return contatos;
	}
	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}
	
	
}
