package br.com.agenda.bd.controller;

import java.io.IOException;

import br.com.agenda.bd.dao.ContatoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Contatosdelete")
public class ContatoDeleteController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idContato = req.getParameter("idContato");
		 
        ContatoDAO.deleteContato(Integer.parseInt(idContato));
        if (req.getAttribute("erro")!= null) {
        	req.getRequestDispatcher("/contatos").forward(req, resp);
        }else {
            resp.sendRedirect("/contatos");
        }
		
	}
}
