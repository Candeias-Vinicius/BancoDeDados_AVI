package br.com.agenda.bd.bo;

import java.sql.SQLException;
import java.util.List;

import br.com.agenda.bd.dao.GrupoDAO;
import br.com.agenda.bd.model.Grupo;

public class GrupoBO {

	
	public static void cadastraGrupo(Grupo grupo) throws Exception {

		GrupoDAO.addGrupo(grupo);
	}
	public static void excluirGrupo(Integer id) throws SQLException {
		GrupoDAO.deleteGrupo(id);
	}
	public static void alterarGrupo(Grupo grupo) throws Exception {

		GrupoDAO.updateGrupo(grupo);
	}
	public static List<Grupo> listarGrupos() throws SQLException{		
		return GrupoDAO.getAllGroups();		
	}
	public static Grupo buscaGrupo(String nome) throws Exception {
		Grupo grupo = GrupoDAO.buscaGrupo(nome);
		if(grupo == null) {
			throw new Exception("O grupo nao existe !");
		}
		return grupo;		
	}
	public static Grupo buscaGrupoPorId(Integer id) throws SQLException {
		return GrupoDAO.buscaGrupoPorId(id);
		
	}
	public static boolean grupoExiste(String nome) throws SQLException {
		Grupo grupo = GrupoDAO.buscaGrupo(nome);
		if(grupo == null) {
			return false;
		}
		return true;		
	}
}
