package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.RecursosBean;
import dao.DaoUsuario;

/**
 * Servlet implementation class CadastraUsuarioServlet
 */
@WebServlet("/cadastraUsuarioServlet")
public class CadastraUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastraUsuarioServlet() {
        super();
        
    }

    DaoUsuario du = new DaoUsuario();
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RecursosBean rb = new RecursosBean();
		rb.setLogin(request.getParameter("usuario"));
		rb.setSenha(request.getParameter("senha"));
		
		du.salvarUsuario(rb);

	}
		
}
