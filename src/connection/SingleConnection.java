package connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Responsável por fazer a conexão com o banco de dados.
 * @author Franklin Sá
 *
 */



public class SingleConnection {
	
	private static String url = "jdbc:postgresql://localhost:5432/treinamento?autoReconnect=true";
	private static String password = "treinafilho" ;
	private static String user = "treinamento";
	
	private static Connection connection = null;
	
	static {
		conectar();
	}
	

	public SingleConnection() {
		conectar();
	}
	
	//método para gerar a conexão
	private static void conectar() {
		try {
			
			if(connection == null) {
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(url, user, password);
				connection.setAutoCommit(false);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao conectar ao banco de dados");
		}
	}
	
	//método para retornar a conexão
	
	public static Connection getConnection() {
		return connection;
	}
	
}
