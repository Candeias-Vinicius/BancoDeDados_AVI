package br.com.agenda.bd.bo;

import java.sql.SQLException;
import java.util.List;
import br.com.agenda.bd.dao.ContatoDAO;
import br.com.agenda.bd.model.Contato;


public class ContatoBO {
	
	private static void validaContato(Contato contato) throws Exception {
		validaNome(contato.getNome());
		validaTelefone(contato.getTelefone());
		validaCelular(contato.getCelular());
		
	}

	private static void validaNome(String nome) throws Exception {
		List<Contato> contatos = ContatoDAO.getAllContacts();
		for (Contato contato : contatos) {
			if (contato.getNome().equals(nome)) {
				throw new Exception("Nome ja existe!");
			}
		}
	}

	private static void validaTelefone(String telefone) throws Exception {
		List<Contato> contatos = ContatoDAO.getAllContacts();
		if(telefone == null || telefone.equals("")) {
			throw new Exception("Por favor, Insira o telefone");
		}
		for (Contato contato : contatos) {
			if (contato.getTelefone().equals(telefone)) {
				throw new Exception("Numero de telefone já existe!");
			}
		}		
	}

	private static void validaCelular(String celular) throws Exception {
		List<Contato> contatos = ContatoDAO.getAllContacts();
		for (Contato contato : contatos) {
			if (contato.getCelular().equals(celular)) {
				throw new Exception("Numero de celular já existe!");
			}
		}		
	}

	public static void cadastraContato(Contato contato) throws Exception {

			validaContato(contato);
			ContatoDAO.addContato(contato);
		
	}
	public static void excluirContato(Integer id) throws SQLException  {				
			ContatoDAO.deleteContato(id);

	}
	public static void alterarContato(Contato contato) throws Exception {
			validaContato(contato);
			ContatoDAO.updateContato(contato);
	}
	
	public static List<Contato> listarContatos() throws SQLException {
		return ContatoDAO.getAllContacts();
	}
	
	public static Contato buscaContato(String nome) throws SQLException, Exception {
		Contato contato = ContatoDAO.buscaContato(nome);
		if(contato == null) {
			throw new Exception("Contato nao foi encontrado !");
		}
		return contato;
		
	}
}
