package testes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import meupacote.Livros;
import meupacote.util.ConnectionLivrariaFactory;

public class TesteConnection {
	
	public static void main(String[] args) {
		Connection conn = ConnectionLivrariaFactory.getConnection();
		
		PreparedStatement ps;
		ResultSet rs;
		
		try {
			ps = conn.prepareStatement("select * from livros");
			rs = ps.executeQuery();
			List<Livros> list = new ArrayList<Livros>();
			while(rs.next()) {
				String isbn = rs.getString(1);
				String titulo = rs.getString(2);
				int edicao = rs.getInt(3);
				String publicacao = rs.getString(4);
				String descricao = rs.getString(5);
				
				System.out.println(titulo);
				list.add(new Livros(isbn, titulo, edicao, publicacao, descricao));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}

}
