package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Chef;

@WebServlet("/chefPortal")
public class ChefPortal extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		Chef chef = null;
		HttpSession session = req.getSession();
		chef = (Chef) session.getAttribute("chef");
		req.setAttribute("chef", chef);
		RequestDispatcher rd = req.getRequestDispatcher("ChefPortal.jsp");
		rd.forward(req, res);
	}
}