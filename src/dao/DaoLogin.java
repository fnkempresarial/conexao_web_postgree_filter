package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connection.SingleConnection;

public class DaoLogin {
	//criar a ponte de conexão.
	private Connection connection;
	
	//Construtor para buscar a conexão ao banco e atribuir ao connection dessa classe
	public DaoLogin() {
		
	connection = SingleConnection.getConnection();	
		
	}

	/*SQL para buscar os logins no banco de dados, tendo como parametro o login e senha
	atribuidos.*/
	public boolean validarLogin(String login, String senha) throws Exception {
		//gerando a string que busca no dado.
		String  sql = "select * from users where login = '" +login+"' AND senha = '" + senha
				 + "';";  
		//System.out.println(sql);
		//preparando a consulta.
		PreparedStatement ps = connection.prepareStatement(sql);
		
		//executando a consulta e guardando seu resultado no rs
		ResultSet rs = ps.executeQuery();
		
		//validando no banco de dados se existe retorno do resultado ou não
		if(rs.next()) {
			return true;
		} else {
			return false;
		}
					
	}
	
}
