package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Manager;

@WebServlet("/managerPortal")
public class ManagerPortal extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		Manager manager = null;
		RequestDispatcher rd = req.getRequestDispatcher("ManagerPortal.jsp");
		HttpSession session = req.getSession();
		manager = (Manager) session.getAttribute("manager");
		req.setAttribute("manager", manager);
		rd.forward(req, res);
	}
}