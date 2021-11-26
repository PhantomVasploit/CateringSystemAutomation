package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Customer;

@WebServlet("/customerPortal")
public class CustomerPortal extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		Customer customer = null;
		customer = (Customer) req.getAttribute("customer");
		req.setAttribute("customer", customer);
		RequestDispatcher rd = req.getRequestDispatcher("CustomerPortal.jsp");
		rd.forward(req, res);
	}
}