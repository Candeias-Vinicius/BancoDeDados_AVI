package br.com.agenda.bd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.agenda.bd.model.Contato;
import br.com.agenda.bd.util.ContatoUtil;

public class ContatoDAO {

	private static Connection connection;

	public ContatoDAO() throws ClassNotFoundException, SQLException {
		connection = ContatoUtil.getConnection();
	}

	public static void addContato(Contato contato) {
		try {
			PreparedStatement preparedStatement = ContatoUtil.getConnection().prepareStatement(
					"insert into contato(contatoid,nome,telefone,celular,grupoid) values (?, ?, ?,?, ?)");

			preparedStatement.setInt(1, contato.getId());
			preparedStatement.setString(2, contato.getNome());
			preparedStatement.setString(3, contato.getTelefone());
			preparedStatement.setString(4, contato.getCelular());
			preparedStatement.setInt(5, contato.getIdGrupo());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void deleteContato(Integer contatoId) {
		try {
			PreparedStatement preparedStatement = ContatoUtil.getConnection()
					.prepareStatement("delete from Contato where contatoid=?");

			preparedStatement.setInt(1, contatoId);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void updateContato(Contato contato) {
		try {
			PreparedStatement preparedStatement = ContatoUtil.getConnection()
					.prepareStatement("update Contato set id=? , nome=?, telefone=?, celular=?, idGrupo=?");

			preparedStatement.setInt(1, contato.getId());
			preparedStatement.setString(2, contato.getNome());
			preparedStatement.setString(3, contato.getTelefone());
			preparedStatement.setString(4, contato.getCelular());
			preparedStatement.setInt(5, contato.getIdGrupo());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static List<Contato> getAllContacts() {
		List<Contato> listaDeUsuario = new ArrayList<Contato>();
		try {
			Statement stmt = ContatoUtil.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery("select * from contato");
			while (rs.next()) {
				Contato contato = new Contato();

				contato.setId(rs.getInt("contatoid"));
				contato.setNome(rs.getString("nome"));
				contato.setTelefone(rs.getString("telefone"));
				contato.setCelular(rs.getString("celular"));
				listaDeUsuario.add(contato);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaDeUsuario;
	}

	public static List<Contato> getContactsForGroups() {
		List<Contato> listaDeUsuario = new ArrayList<Contato>();
		try {
			Statement stmt = ContatoUtil.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery("select contatoid, contato.grupoid,"
					+ " contato.nome, contato.telefone, contato.celular from contato "
					+ "inner join grupo on contato.grupoid = grupo.grupoid");
			while (rs.next()) {
				Contato contato = new Contato();

				contato.setId(rs.getInt("contatoid"));
				contato.setNome(rs.getString("nome"));
				contato.setTelefone(rs.getString("telefone"));
				contato.setCelular(rs.getString("celular"));
				contato.setIdGrupo(rs.getInt("grupoid"));
				listaDeUsuario.add(contato);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaDeUsuario;
	}
}
