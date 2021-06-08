package br.com.agenda.bd.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ContatoUtil {

	private static final String URL = "jdbc:potgresql://localhost:5432/potgres";
	private static final String USER = "postgres";
	private static final String PASS = "Santabarbara@16";
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		
		Class.forName("org.postgresql.Driver");
		Connection connection = DriverManager.getConnection(URL,USER,PASS);
		if(connection != null) {
			System.out.println("Conexão efetuado com sucesso...");
			return connection;
		}
		System.out.println("Deu ruim");
		return null;
		
	}
	

}
