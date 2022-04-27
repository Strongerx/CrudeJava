package br.com.agenda.aplicacao;

import java.util.Date;

import br.com.agenda.dao.ContatoDAO;
import br.com.agenda.model.Contato;

public class Main {

	public static void main(String[] args) {
		
		
		ContatoDAO contatoDao = new ContatoDAO();
		
		Contato contato = new Contato();
		contato.setNome("Leonardo Cunha Soares");
		contato.setIdade(18);
		contato.setDataCadastro(new Date());
		
		//Salva no banco de dados
		contatoDao.save(contato);
		
		Contato c1 = new Contato();
		c1.setNome("Leonardo soares");
		c1.setIdade(19);
		c1.setDataCadastro(new Date());
		c1.setId(5);
		
		//Atualizar o contato
		contatoDao.update(c1);
		
		//Deletar o contato pelo seu n�mero de ID
		contatoDao.deleteByID(4);
		
		//Vizualiza��o dos registros do banco de dados no console
		for (Contato c : contatoDao.getContatos()) {
			System.out.println("Contato: " + c.getNome());
		}
	}

	
}
