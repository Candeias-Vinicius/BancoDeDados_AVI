package br.com.agenda.bd.controller;

import java.io.IOException;
import java.util.List;

import br.com.agenda.bd.dao.GrupoDAO;
import br.com.agenda.bd.model.Grupo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/grupos/register")
public class GrupoRegisterController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String nome = req.getParameter("nome");
		
		try {
			AddGrupo(nome);
		} catch (Exception e) {
			req.setAttribute("erro", e.getMessage());
			req.getRequestDispatcher("/grupoform.jsp").forward(req,resp);
			e.printStackTrace();
		}
		resp.sendRedirect("/grupos");
		}

	private void AddGrupo(String nome) throws Exception {
		validaNome(nome);
		Grupo grupo = new Grupo(nome);
		GrupoDAO.addGrupo(grupo);
		
	}

	private void validaNome(String nome) throws Exception {
		List<Grupo> grupos = GrupoDAO.getAllGroups();
		for(Grupo grupo: grupos) {
			if(grupo.getNome().equals(nome)) {
				throw new Exception("Grupo já existe! ");
			}
		}
	}
	}

