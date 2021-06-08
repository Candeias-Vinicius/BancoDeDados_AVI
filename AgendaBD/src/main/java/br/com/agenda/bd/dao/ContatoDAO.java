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
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into Contato(id,nome,telefone,celular,grupo) values (?, ?, ?,?,?)");

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
			PreparedStatement preparedStatement = connection.prepareStatement("delete from Contato where id=?");

			preparedStatement.setInt(1, contatoId);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void updateContato(Contato contato) {
		try {
			PreparedStatement preparedStatement = connection
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
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Contato");
			while (rs.next()) {
				Contato contato = new Contato();
				
				contato.setId(rs.getInt("id"));
				contato.setNome(rs.getString("nome"));
				contato.setTelefone(rs.getString("telefone"));
				contato.setCelular(rs.getString("celular"));
				contato.setIdGrupo(rs.getInt("idGrrupo"));
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
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select grupo * from Contato");
			while (rs.next()) {
				Contato contato = new Contato();
				
				contato.setId(rs.getInt("id"));
				contato.setNome(rs.getString("nome"));
				contato.setTelefone(rs.getString("telefone"));
				contato.setCelular(rs.getString("celular"));
				contato.setIdGrupo(rs.getInt("idGrupo"));
				listaDeUsuario.add(contato);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaDeUsuario;
	}
}
