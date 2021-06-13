package br.com.agenda.bd.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.agenda.bd.model.Grupo;
import br.com.agenda.bd.util.ContatoUtil;

public class GrupoDAO {

	public static void addGrupo(Grupo grupo) throws SQLException {

			PreparedStatement preparedStatement = ContatoUtil.getConnection()
					.prepareStatement("insert into grupo(nome) values (?)");


			preparedStatement.setString(1, grupo.getNome());

			preparedStatement.executeUpdate();

	}

	public static void deleteGrupo(Integer grupoid) throws SQLException {
	
			PreparedStatement preparedStatement = ContatoUtil.getConnection().prepareStatement("delete from grupo where grupoid=?");

			preparedStatement.setInt(1, grupoid);
			preparedStatement.executeUpdate();

	}

	public static void updateGrupo(Grupo grupo) {
		try {
			PreparedStatement preparedStatement = ContatoUtil.getConnection()
					.prepareStatement("update grupo set nome=? where grupoid=?");

			preparedStatement.setString(1, grupo.getNome());
			preparedStatement.setInt(2, grupo.getId());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	} 

	public static List<Grupo> getAllGroups() throws SQLException {
		List<Grupo> listaDeGrupos = new ArrayList<Grupo>();
		
			Statement stmt = ContatoUtil.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery("select * from grupo");
			while (rs.next()) {
				Grupo grupo = new Grupo();

				grupo.setId(rs.getInt("grupoid"));
				grupo.setNome(rs.getString("nome"));

				listaDeGrupos.add(grupo);
			}


		return listaDeGrupos;
	}

	public static Grupo buscaGrupo (String nomeGrupo) throws SQLException {
		List<Grupo> grupos = GrupoDAO.getAllGroups();
		for (Grupo grupo : grupos) {
			if(grupo.getNome().equals(nomeGrupo)) {
				return grupo;
			}
		}
		return null;		
	}
	public static Grupo buscaGrupoPorId (Integer grupoid) throws SQLException {
		List<Grupo> grupos = GrupoDAO.getAllGroups();
		for (Grupo grupo : grupos) {
			if(grupo.getId().equals(grupoid)) {
				return grupo;
			}
		}
		return null;
		
	}
}
