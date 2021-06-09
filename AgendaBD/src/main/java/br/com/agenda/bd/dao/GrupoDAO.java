package br.com.agenda.bd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.agenda.bd.model.Grupo;
import br.com.agenda.bd.util.ContatoUtil;

public class GrupoDAO {

	private static Connection connection;

	public GrupoDAO() throws ClassNotFoundException, SQLException {
		connection = ContatoUtil.getConnection();
	}

	public static void addGrupo(Grupo grupo) {
		try {
			PreparedStatement preparedStatement = ContatoUtil.getConnection()
					.prepareStatement("insert into Grupo(grupoid, nome) values (?,?)");

			preparedStatement.setObject(1, grupo.getId());
			preparedStatement.setObject(2, grupo.getNome());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void deleteGrupo(Integer id) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("delete from Grupo where id=?");

			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void updateContato(Grupo grupo) {
		try {
			PreparedStatement preparedStatement = ContatoUtil.getConnection()
					.prepareStatement("update Contato set grupo=?");

			preparedStatement.setObject(1, grupo.getNome());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static List<Grupo> getAllGroups() {
		List<Grupo> listaDeGrupos = new ArrayList<Grupo>();
		try {
			Statement stmt = ContatoUtil.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery("select * from Grupo");
			while (rs.next()) {
				Grupo grupo = new Grupo(null, null);

				grupo.setId(rs.getInt("grupoid"));
				grupo.setNome(rs.getString("nome"));

				listaDeGrupos.add(grupo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaDeGrupos;
	}

}
