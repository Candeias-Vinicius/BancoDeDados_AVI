package br.com.agenda.bd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import br.com.agenda.bd.model.GrupoContato;
import br.com.agenda.bd.model.TipoGrupoEnum;
import br.com.agenda.bd.util.ContatoUtil;

public class GrupoDAO {
	
	private static Connection connection;
	
	public GrupoDAO() {
		ContatoUtil.getConnection();
	}
	public static void addContato(GrupoContato grupo) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into Grupo(grupo) values (?)");

			preparedStatement.setObject(1, grupo.getTipoGrupo());
			
			
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void deleteContato(TipoGrupoEnum nomeGrupo) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("delete from Contato where grupo=?");

			preparedStatement.setString(1, nomeGrupo.getValorEnum());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void updateContato(GrupoContato grupo) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update Contato set grupo=?");
			
			preparedStatement.setObject(1, grupo.getTipoGrupo());
			
			
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static List<GrupoContato> getAllGroups() {
		List<GrupoContato> listaDeGrupos = new ArrayList<GrupoContato>();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Grupo");
			while (rs.next()) {
				GrupoContato grupo = new GrupoContato();
				
				String nomeGrupo = rs.getString("nomeGrupo");
				grupo.setTipoGrupo(TipoGrupoEnum.valueOf(nomeGrupo));
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaDeGrupos;
	}
	
}
