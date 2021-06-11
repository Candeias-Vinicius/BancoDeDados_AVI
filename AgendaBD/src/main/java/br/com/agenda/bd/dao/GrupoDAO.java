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

	public static void addGrupo(Grupo grupo) {
		try {
			PreparedStatement preparedStatement = ContatoUtil.getConnection()
					.prepareStatement("insert into grupo(nome) values (?)");


			preparedStatement.setString(1, grupo.getNome());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void deleteGrupo(Integer grupoid) {
		try {
			PreparedStatement preparedStatement = ContatoUtil.getConnection().prepareStatement("delete from grupo where grupoid=?");

			preparedStatement.setInt(1, grupoid);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
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

	public static List<Grupo> getAllGroups() {
		List<Grupo> listaDeGrupos = new ArrayList<Grupo>();
		try {
			Statement stmt = ContatoUtil.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery("select * from grupo");
			while (rs.next()) {
				Grupo grupo = new Grupo();

				grupo.setId(rs.getInt("grupoid"));
				grupo.setNome(rs.getString("nome"));

				listaDeGrupos.add(grupo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaDeGrupos;
	}

	public static Grupo buscaGrupo (String nomeGrupo) {
		List<Grupo> grupos = GrupoDAO.getAllGroups();
		for (Grupo grupo : grupos) {
			if(grupo.getNome().equals(nomeGrupo)) {
				return grupo;
			}
		}
		return null;		
	}
	public static Grupo buscaGrupoPorId (Integer grupoid) {
		List<Grupo> grupos = GrupoDAO.getAllGroups();
		for (Grupo grupo : grupos) {
			if(grupo.getId().equals(grupoid)) {
				return grupo;
			}
		}
		return null;
		
	}
}
