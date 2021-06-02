package br.com.agenda.bd.model;

public enum TipoGrupoEnum {
	
	Familia(1), Amigos(2), Trabalho(3), Outros(4);
	


private final int valor;

TipoGrupoEnum(int i) {
	valor = i;
}
	
public int getValor() {
	return valor;
}
}
