package br.com.agenda.bd.model;


public class GrupoContato {

	private TipoGrupoEnum tipoGrupo;
	
	public GrupoContato(TipoGrupoEnum tipoGrupo) {
		super();
		this.tipoGrupo = tipoGrupo;
		
	}	
	public GrupoContato() {
		super();
	}
	public TipoGrupoEnum getTipoGrupo() {
		return tipoGrupo;
	}
	public void setTipoGrupo(TipoGrupoEnum tipoGrupo) {
		this.tipoGrupo = tipoGrupo;
	}
	
}
