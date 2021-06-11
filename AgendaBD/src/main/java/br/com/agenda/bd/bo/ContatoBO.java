package br.com.agenda.bd.bo;

import java.util.List;

import br.com.agenda.bd.dao.ContatoDAO;
import br.com.agenda.bd.dao.GrupoDAO;
import br.com.agenda.bd.model.Contato;
import br.com.agenda.bd.model.Grupo;

public class ContatoBO {
	
	private static void validaContato(Contato contato) throws Exception {
		validaNome(contato.getNome());
		validaTelefone(contato.getTelefone());
		validaCelular(contato.getCelular());
		validaIdGrupo(contato.getIdGrupo());
		
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

	private static void validaIdGrupo(Integer idGrupo) throws Exception {
		List<Grupo> grupos = GrupoDAO.getAllGroups();
		for (Grupo grupo : grupos) {
			if (grupo.getId().equals(idGrupo)) {
				
			}else {
				throw new Exception("Numero de celular já existe!");
			}
		}		
	}
	public static void cadastraContato(Contato contato) {
		try {
			validaContato(contato);
			System.out.println("Contato Adicionado com sucesso! ");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		ContatoDAO.addContato(contato);
	}
}
