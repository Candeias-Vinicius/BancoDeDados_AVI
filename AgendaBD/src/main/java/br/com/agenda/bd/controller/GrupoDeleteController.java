package br.com.agenda.bd.controller;

import java.io.IOException;

import br.com.agenda.bd.dao.GrupoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/grupos/delete")
public class GrupoDeleteController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idGrupo = req.getParameter("idGrupo");
		
		GrupoDAO.deleteGrupo(Integer.parseInt(idGrupo));
		
		if (req.getAttribute("erro")!= null) {
        	req.getRequestDispatcher("/grupos").forward(req, resp);
        }else {
            resp.sendRedirect("/grupos");
        }
	}
}
