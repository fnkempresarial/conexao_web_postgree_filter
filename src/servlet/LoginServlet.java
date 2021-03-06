package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoLogin;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private DaoLogin daoLogin = new DaoLogin();
	

	public LoginServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException  {
		
		doPost(request,response);
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		try {
			if(daoLogin.validarLogin(login, senha)) {
			RequestDispatcher rd = request.getRequestDispatcher("logado.jsp");
			rd.forward(request, response);
			} else {
			RequestDispatcher rd = request.getRequestDispatcher("goback.jsp");
			rd.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}
