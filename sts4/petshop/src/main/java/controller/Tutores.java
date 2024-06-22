package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Tutor;
import utils.ServletTools;

@WebServlet("/tutor")
public class Tutores extends HttpServlet {
	
	static List<Tutor> list = new ArrayList<Tutor>();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sid = req.getParameter("id");
		if (sid == null) {
			ServletTools.send(resp, list);
			return;
		}
		int id = Integer.parseInt(req.getParameter("id"));
		
		ServletTools.send(resp, list.get(id).toString());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Tutor tutor = ServletTools.jsonTo(Tutor.class, req);
		list.add(tutor);
		ServletTools.send(resp, "Tutor adicionado com sucesso!");
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sid = req.getParameter("id");
		if (sid == null) {
			ServletTools.send(resp, "ID inválido.");
			return;
		}
		int id = Integer.parseInt(req.getParameter("id"));
		
		Tutor tutor = ServletTools.jsonTo(Tutor.class, req);
		list.set(id, tutor);
		ServletTools.send(resp, "PET alterado.");
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sid = req.getParameter("id");
		if (sid == null) {
			ServletTools.send(resp, "ID inválido.");
			return;
		}
		int id = Integer.parseInt(req.getParameter("id"));
		
		list.remove(id);
		ServletTools.send(resp, "Tutor removido");
	}

}
