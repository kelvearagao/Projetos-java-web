package meupacote;

public class Livros {
	
	private String isbn;
	private String titulo;
	private int edicao;
	private String publicacao;
	private String descricao;
	
	
	public Livros(){}
	
	public Livros(String isbn, String titulo, int edicao, String publicacao,
			String descricao) {
		this.isbn = isbn;
		this.titulo = titulo;
		this.edicao = edicao;
		this.publicacao = publicacao;
		this.descricao = descricao;
	}
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getEdicao() {
		return edicao;
	}
	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}
	public String getPublicacao() {
		return publicacao;
	}
	public void setPublicacao(String publicacao) {
		this.publicacao = publicacao;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

}
