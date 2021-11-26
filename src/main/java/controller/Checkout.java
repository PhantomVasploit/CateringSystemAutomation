package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Order;

@WebServlet("/orders")
public class Checkout extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		@SuppressWarnings("unchecked")
		ArrayList<Order> confirmedOrders =(ArrayList<Order>) req.getAttribute("confirmedOrders");
		req.setAttribute("confirmedOrders", confirmedOrders);
		RequestDispatcher rd = req.getRequestDispatcher("Orders.jsp");
		rd.forward(req, res);
	}
}