package meupacote.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import meupacote.Livros;

public class ConnectionLivrariaFactory {
	
	public static Connection getConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/livraria","root","12345");
			System.out.println("Conexão -> Sucesso!");
			
			return conn;	
		} catch (Exception e) {
			e.printStackTrace();
            throw new RuntimeException(e);
		}
	}
	
	public static void closeConnection(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (rs!=null) rs.close();
			if (stmt!=null) stmt.close();
			if (conn !=null) conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}




