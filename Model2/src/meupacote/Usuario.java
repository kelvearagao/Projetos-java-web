package meupacote;

public class Usuario {
	private String usuario = null;
	private String senha = null;
	
	public void setUsuario(String usuario){
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getUsuario() {
		return usuario;
	}
	
	public boolean verificaUsuario() {
		if (this.usuario != null && this.senha != null){
			if (this.usuario.equals("kelve") && this.senha.equals("12345"))
				return true;
		}
		return false;
	}
	
	
}
