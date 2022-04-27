package br.com.agenda.factory;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionFactory {

	/**
	 * Conex�o com o Banco de Dados	 *  	  
	 */
	public static Connection createConnectionToMySql() throws Exception {
		
		//Cria conex�o com o Banco de Dados MYSQL
		Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/agenda?useTimezone=true&serverTimezone=UTC",
						"root", // -USERNAME
						"root");// -PASSWORD
		return connection;
	}
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		
		//Recuperar uma conex�o com o banco de dados
		Connection con = createConnectionToMySql();
		
		//Testar se a conex�o � nula
		if(con != null) {
			System.out.println("Conex�o obtida com sucesso !");
			con.close();
		}
		
	}
}
