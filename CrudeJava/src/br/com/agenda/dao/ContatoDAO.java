package br.com.agenda.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.agenda.factory.ConnectionFactory;
import br.com.agenda.model.Contato;

public class ContatoDAO {

	public void save(Contato contato) {

		// string SQL
		String sql = "INSERT INTO contatos(nome, idade, datacadastro) VALUES (?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			// Cria Conexão com o Banco de Dados
			conn = ConnectionFactory.createConnectionToMySql();
			// Criamos um PreparedStatement, para executar uma query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			// Adicionar os valores que são esperados pela query
			pstm.setString(1, contato.getNome());
			pstm.setInt(2, contato.getIdade());
			pstm.setDate(3, new java.sql.Date(contato.getDataCadastro().getTime()));

			pstm.execute();

			System.out.println("Contato salvo com sucesso !");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Fechar as conexões
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					pstm.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void update(Contato contato) {
		
		String sql = "UPDATE contatos SET nome = ?, idade = ?, datacadastro = ? "+
		"WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			
			//Cria conexão com o banco
			conn = ConnectionFactory.createConnectionToMySql();
			
			//Cria a classe para executar a query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			//Adicionar os valores para atualizar
			pstm.setString(1, contato.getNome());
			pstm.setInt(2, contato.getIdade());
			pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));
			pstm.setInt(4, contato.getId());
			
			//Executar a query
			pstm.execute();
			
			System.out.println();
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void deleteByID(int id) {
		
		String sql = "DELETE FROM contatos WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//Faz a conexão com o banco de dados
			conn = ConnectionFactory.createConnectionToMySql();
			
			//Cria a classe para executar a query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			pstm.execute();
			
			System.out.println("Contato deletado com sucesso !");
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<Contato> getContatos(){
		
		String sql = "SELECT * FROM contatos";
		
		List<Contato> contatos = new ArrayList<Contato>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		//Classe que vai recuperar os dados do Banco MYSQL ****SELECT****
		ResultSet rst = null;
		
		try {
			
			conn = ConnectionFactory.createConnectionToMySql();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			rst = pstm.executeQuery();
			
			while (rst.next()) {
				
				Contato contato = new Contato();
				
				//Recuperar o id
				contato.setId(rst.getInt("id"));
				//Recupera o nome
				contato.setNome(rst.getString("nome"));
				//Recupera a idade
				contato.setIdade(rst.getInt("idade"));
				contato.setDataCadastro(rst.getDate("datacadastro"));
				
				contatos.add(contato);
				}
		}catch(Exception e){
			e.printStackTrace();
			}finally {
				try {
					if(rst != null) {
						rst.close();
					}
					if(pstm != null) {
						pstm.close();
					}
					if(conn != null) {
						conn.close();				
					}
				}catch(Exception e) {
					e.printStackTrace();
					}
				}	
				return contatos;
			
				
	}
}
