package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bean.RecursosBean;
import connection.SingleConnection;

public class DaoUsuario {

	private Connection connection;
	
	public DaoUsuario () {
	connection = SingleConnection.getConnection();	
	}
	
	public void salvarUsuario(RecursosBean rb) {
		try {
		String sql = "insert into users (login, senha) values ( ?, ? ); ";
		
		PreparedStatement ps = connection.prepareStatement(sql);
		//System.out.println(sql);
		ps.setString(1, rb.getLogin());
		ps.setString(2, rb.getSenha());
		ps.execute();
		connection.commit();
		}catch(Exception e) {
			
			try {
				connection.rollback();
			} catch (SQLException e1) {				
				e1.printStackTrace();				
			}
			e.printStackTrace();
		
		}
	}
	
	
	
}
