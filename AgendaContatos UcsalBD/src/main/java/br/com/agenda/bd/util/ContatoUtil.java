package br.com.agenda.bd.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ContatoUtil {
	
	private static Connection connection = null;

    public static Connection getConnection() {
        if (connection != null)
            return connection;
        else {
            try {
                
                String user = "postgres";
                String password = "123456";
                
                Class.forName("org.postgresql.Driver");
                
                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/contato",user, password);// Trocar "contato" pelo nome do nosso banco
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return connection;
        }

    }
	
	
}
