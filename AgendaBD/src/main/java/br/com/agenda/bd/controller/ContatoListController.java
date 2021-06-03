package br.com.agenda.bd.controller;

import java.io.IOException;

import br.com.agenda.bd.dao.ContatoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Contatos")
public class ContatoListController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setAttribute("contatos", ContatoDAO.getAllUsers());
		req.getRequestDispatcher("").forward(req, resp);
	}
}
