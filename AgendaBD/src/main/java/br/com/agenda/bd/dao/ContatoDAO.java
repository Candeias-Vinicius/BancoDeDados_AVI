package br.com.agenda.bd.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.agenda.bd.model.Contato;
import br.com.agenda.bd.util.ContatoUtil;

public class ContatoDAO {

	
	public static void addContato(Contato contato) {
		try {
			PreparedStatement preparedStatement = ContatoUtil.getConnection().prepareStatement(
					"insert into contato(nome,telefone,celular,grupoid) values (?, ?,?, ?)");

			
			preparedStatement.setString(1, contato.getNome());
			preparedStatement.setString(2, contato.getTelefone());
			preparedStatement.setString(3, contato.getCelular());
			preparedStatement.setInt(4, contato.getIdGrupo());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void deleteContato(Integer contatoId) {
		try {
			PreparedStatement preparedStatement = ContatoUtil.getConnection()
					.prepareStatement("delete from contato where contatoid=?");

			preparedStatement.setInt(1, contatoId);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void updateContato(Contato contato) {
		try {
			PreparedStatement preparedStatement = ContatoUtil.getConnection()
					.prepareStatement("update contato set nome=?, telefone=?, celular=?, grupoid=? where contatoid=?");
			
			
			preparedStatement.setString(1, contato.getNome());
			preparedStatement.setString(2, contato.getTelefone());
			preparedStatement.setString(3, contato.getCelular());
			preparedStatement.setInt(4, contato.getIdGrupo());
			preparedStatement.setInt(5, contato.getId());
			
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
				contato.setIdGrupo(rs.getInt("grupoid"));
				listaDeUsuario.add(contato);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaDeUsuario;
	}

	public static Contato buscaContato (String nome) {
		List<Contato> contatos = ContatoDAO.getAllContacts();
		for (Contato contato : contatos) {
			if(contato.getNome().equals(nome)) {
				return contato;
			}
		}
		return null;
		
	}
}
