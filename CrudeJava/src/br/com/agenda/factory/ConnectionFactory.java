package br.com.agenda.factory;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionFactory {

	/**
	 * Conexão com o Banco de Dados	 *  	  
	 */
	public static Connection createConnectionToMySql() throws Exception {
		
		//Cria conexão com o Banco de Dados MYSQL
		Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/agenda?useTimezone=true&serverTimezone=UTC",
						"root", // -USERNAME
						"root");// -PASSWORD
		return connection;
	}
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		
		//Recuperar uma conexão com o banco de dados
		Connection con = createConnectionToMySql();
		
		//Testar se a conexão é nula
		if(con != null) {
			System.out.println("Conexão obtida com sucesso !");
			con.close();
		}
		
	}
}
