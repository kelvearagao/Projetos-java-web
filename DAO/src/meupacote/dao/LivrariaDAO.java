package meupacote.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import meupacote.Livros;
import meupacote.util.ConnectionLivrariaFactory;

public class LivrariaDAO {
	
	private Connection conn;
	
	public LivrariaDAO() {
		this.conn = ConnectionLivrariaFactory.getConnection();
	}
	
	public void salvar(Livros livro) {
		PreparedStatement ps = null;
		Connection conn = null;
		if (livro != null) {
			String SQL = "INSERT INTO livros (isbn, titulo, edicao_num, ano_publicacao, descricao)"+
							"values (?, ?, ?, ?, ?)";
			conn = this.conn;
			try {
				ps = conn.prepareStatement(SQL);
				ps.setString(1, livro.getIsbn());
				ps.setString(2, livro.getTitulo());
				ps.setInt(3, livro.getEdicao());
				ps.setString(4, livro.getPublicacao());
				ps.setString(5, livro.getDescricao());
				ps.executeUpdate();
				System.out.println("Salvo com sucesso!");				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				ConnectionLivrariaFactory.closeConnection(conn, ps, null);
			}
		}
	}
	
	public void excluir(Livros livro) {
		PreparedStatement ps = null;
		Connection conn = null;
		
		if (livro != null) {
			conn = this.conn;
			try {
				ps = conn.prepareStatement("delete from livros where isbn=?");
				ps.setString(1, livro.getIsbn());
				ps.executeUpdate();
				System.out.println("Excluido com sucesso!");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				ConnectionLivrariaFactory.closeConnection(conn, ps, null);
			}
		}
	}
	
	public void atualizar(Livros livro){
		PreparedStatement ps = null;
		Connection conn = null;
		if (livro != null) {
			String SQL = "UPDATE livros SET titulo=?, edicao_num=?, ano_publicacao=?, descricao=? "+
						"where isbn=?";
			conn = this.conn;
			try {
				ps = conn.prepareStatement(SQL);
				
				ps.setString(1, livro.getTitulo());
				ps.setInt(2, livro.getEdicao());
				ps.setString(3, livro.getPublicacao());
				ps.setString(4, livro.getDescricao());
				ps.setString(5, livro.getIsbn());
				ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				ConnectionLivrariaFactory.closeConnection(conn, ps, null);
			}
		}
	}
	
	public List<Livros> todosLivros() {
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet rs = null;
		
		
		try {
			conn = this.conn;
			ps = conn.prepareStatement("select * from livros");
			rs = ps.executeQuery();
			List<Livros> list = new ArrayList<Livros>();
			while(rs.next()) {
				String isbn = rs.getString(1);
				String titulo = rs.getString(2);
				int edicao = rs.getInt(3);
				String publicacao = rs.getString(4);
				String descricao = rs.getString(5);
				
				list.add(new Livros(isbn, titulo, edicao, publicacao, descricao));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionLivrariaFactory.closeConnection(conn, ps, rs);
		}
		return null;
	}
	
	public Livros procurarLivro(String isbn) {
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet rs = null;
		
		conn = this.conn;
		try {
			ps = conn.prepareStatement("select * from livros where isbn=?");
			ps.setString(1, isbn);
			rs = ps.executeQuery();
			
			if (rs.next()){
				String titulo = rs.getString(2);
				int edicao = rs.getInt(3);
				String publicacao = rs.getString(4);
				String descricao = rs.getString(5);
				
				return new Livros(isbn, titulo, edicao, publicacao, descricao);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionLivrariaFactory.closeConnection(conn, ps, rs);
		}
		return null;
	}
	
}
