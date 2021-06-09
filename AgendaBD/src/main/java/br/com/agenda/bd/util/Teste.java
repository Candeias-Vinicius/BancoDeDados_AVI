package br.com.agenda.bd.util;

import java.sql.SQLException;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import br.com.agenda.bd.dao.ContatoDAO;
import br.com.agenda.bd.dao.GrupoDAO;
import br.com.agenda.bd.model.Contato;
import br.com.agenda.bd.model.Grupo;

public class Teste {
	public static void main(String[] arrgs) {

		/*
		 * Grupo grupo = new Grupo(nome, id); GrupoDAO.addGrupo(grupo);
		 */

		/*
		 * Contato contato = new Contato(2, "Jeane", "126711828", "2377832873",13);
		 * ContatoDAO.addContato(contato);
		 */

		/*
		 * List<Contato> contatos = ContatoDAO.getAllContacts(); for (Contato contato :
		 * contatos) { System.out.println(contato);
		 */

		/* ContatoDAO.deleteContato(2); */

		List<Contato> contatos = ContatoDAO.getContactsForGroups();
		for (Contato contato : contatos) {
			System.out.println(contato);
		}

	}

}
