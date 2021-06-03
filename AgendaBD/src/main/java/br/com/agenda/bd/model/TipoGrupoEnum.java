package br.com.agenda.bd.model;

public enum TipoGrupoEnum {
	
	Familia("Familia"), Amigos("Amigos"), Trabalho("Trabalho"), Outros("Outros");
	
private final String valorEnum;

TipoGrupoEnum(String valor) {
	valorEnum = valor;
}
	
public String getValorEnum() {
	return valorEnum;
}
}
