package meupacote;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Logar
 */
@WebServlet("/Logar")
public class Logar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		
		Usuario user = new Usuario();
		user.setUsuario(usuario);
		user.setSenha(senha);
		
		RequestDispatcher rd = null;
		
		if (user.verificaUsuario()){
			HttpSession sessao = request.getSession();
			sessao.setAttribute("USER", usuario);
			rd = request.getRequestDispatcher("/logado.jsp");
			rd.forward(request, response);
		} else {
			request.setAttribute("msg", "Usuário ou Senha inválido");
			rd = request.getRequestDispatcher("/logar.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
