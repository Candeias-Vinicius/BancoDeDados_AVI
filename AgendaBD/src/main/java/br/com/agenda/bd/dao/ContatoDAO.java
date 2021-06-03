package br.com.agenda.bd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.agenda.bd.model.Contato;
import br.com.agenda.bd.model.TipoGrupoEnum;
import br.com.agenda.bd.util.ContatoUtil;

public class ContatoDAO {

	private static Connection connection;

	public ContatoDAO() {
		ContatoUtil.getConnection();
	}

	public static void addContato(Contato contato) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into users(id,nome,telefone,celular,grupo) values (?, ?, ?,?,?)");

			preparedStatement.setInt(1, contato.getId());
			preparedStatement.setString(2, contato.getNome());
			preparedStatement.setString(3, contato.getTelefone());
			preparedStatement.setString(4, contato.getCelular());
			preparedStatement.setString(5, contato.getGrupo().getValorEnum());
			
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void deleteContato(Integer contatoId) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("delete from users where id=?");

			preparedStatement.setLong(1, contatoId);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void updateContato(Contato contato) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update users set id=? , nome=?, telefone=?, celular=?, grupo=?");
			
			preparedStatement.setInt(1, contato.getId());
			preparedStatement.setString(2, contato.getNome());
			preparedStatement.setString(3, contato.getTelefone());
			preparedStatement.setString(4, contato.getCelular());
			preparedStatement.setString(5, contato.getGrupo().getValorEnum());
			
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static List<Contato> getAllContacts() {
		List<Contato> listaDeUsuario = new ArrayList<Contato>();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from contatos");
			while (rs.next()) {
				Contato contato = new Contato();
				
				contato.setId(rs.getInt("id"));
				contato.setNome(rs.getString("nome"));
				contato.setTelefone(rs.getString("telefone"));
				contato.setCelular(rs.getString("celular"));
				String grupo = rs.getString("grupo");
				contato.setGrupo(TipoGrupoEnum.valueOf(grupo));
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
			ResultSet rs = stmt.executeQuery("select grupo * from contatos");
			while (rs.next()) {
				Contato contato = new Contato();
				
				contato.setId(rs.getInt("id"));
				contato.setNome(rs.getString("nome"));
				contato.setTelefone(rs.getString("telefone"));
				contato.setCelular(rs.getString("celular"));
				String grupo = rs.getString("grupo");
				contato.setGrupo(TipoGrupoEnum.valueOf(grupo));
				listaDeUsuario.add(contato);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaDeUsuario;
	}
}
