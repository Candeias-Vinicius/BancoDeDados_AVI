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
	
	private Connection connection;
	
	public ContatoDAO() {
		ContatoUtil.getConnection();
	}
	
	public void addContato(Contato contato) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into users(nome,telefone,celular) values (?, ?, ?)");
            
            preparedStatement.setString(1, contato.getNome());
            preparedStatement.setString(2, contato.getTelefone());           
            preparedStatement.setString(3, contato.getCelular());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteContato(int contatoId) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from users where id=?");
            
            preparedStatement.setInt(1, contatoId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateContato(Contato contato) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update users set nome=?, telefone=?, celular=?");
            
            preparedStatement.setString(1, contato.getNome());
            preparedStatement.setString(2, contato.getTelefone());
            preparedStatement.setString(3, contato.getCelular());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Contato> getAllUsers() {
        List<Contato> listaDeUsuario = new ArrayList<Contato>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from contatos");
            while (rs.next()) {
                Contato contato = new Contato();
                
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

}
