package br.com.agenda.bd.controller;

import java.io.IOException;
import java.util.List;

import br.com.agenda.bd.dao.ContatoDAO;
import br.com.agenda.bd.model.Contato;
import br.com.agenda.bd.model.TipoGrupoEnum;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/contatos/update")
public class ContatoSaveUpdateController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		String nome = req.getParameter("nome");
		String telefone = req.getParameter("telefone");
		String celular = req.getParameter("celular");
		String grupo = req.getParameter("grupo");
		
		try {
			UpdateContato(id, nome, telefone, celular, grupo);
		} catch (Exception e) {
			req.setAttribute("erro", e.getMessage());
			req.getRequestDispatcher("/contatos/contatoform.jsp").forward(req, resp);
			e.printStackTrace();
		}
	}
	
	private void UpdateContato(String id, String nome, String telefone, String celular, String grupo) throws Exception {
		
		validaTelefone(telefone);
		validaCelular(celular);
		Contato contato = new Contato(nome, celular, telefone, TipoGrupoEnum.valueOf(grupo));
		Integer i = Integer.parseInt(id);
		contato.setId(i);

		ContatoDAO.updateContato(contato);		
	}

		private void validaCelular(String celular) throws Exception {
		
		List<Contato> contatos = ContatoDAO.getAllUsers();
		for(Contato contato : contatos) {
			if(contato.getCelular().equals(celular)) {
				throw new Exception("Numero de celular ja está cadastrado! ");
			}
		}
	}

		private void validaTelefone(String telefone) throws Exception {
		
		List<Contato> contatos = ContatoDAO.getAllUsers();
		for(Contato contato : contatos) {
			if(contato.getCelular().equals(telefone)) {
				throw new Exception("Numero de telefone ja está cadastrado! ");
			}
		}
	}
}
