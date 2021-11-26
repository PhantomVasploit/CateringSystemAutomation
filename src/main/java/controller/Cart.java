package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Order;

@WebServlet("/cart")
public class Cart extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		HttpSession session = req.getSession();
		session.getAttribute("orders");
		@SuppressWarnings("unchecked")
		ArrayList<Order> orders = (ArrayList<Order>) session.getAttribute("orders");
		for(Order order : orders)
		{
			System.out.println(order.getFoodItem());
		}
		req.setAttribute("orders", orders);
		RequestDispatcher rd = req.getRequestDispatcher("Cart.jsp");
		rd.forward(req, res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		// set request attribute storing the confirmed orders
		ArrayList<Order> confirmedOrders = new ArrayList<Order>();
		String orderName = req.getParameter("orderName");
		String orderAmount = req.getParameter("orderAmount");
		String orderCost = req.getParameter("orderCost");
		Order order = new Order(orderName, Integer.parseInt(orderAmount), Float.parseFloat(orderCost));
		confirmedOrders.add(order);
		req.setAttribute("confirmedOrders", confirmedOrders);
		res.sendRedirect("orders");
	}
}