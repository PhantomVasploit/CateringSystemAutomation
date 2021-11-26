package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datastore.FoodItemsDao;
import model.FoodItem;
import model.Order;

@WebServlet("/cashierE_Menu")
public class CashierE_Menu extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		try
		{
			java.util.Date date = new Date();
			java.sql.Date today = new java.sql.Date(date.getTime());
			FoodItemsDao foodItems = new FoodItemsDao();
			ArrayList<FoodItem> todayMenu = new ArrayList<FoodItem>();
			ArrayList<FoodItem> data = new ArrayList<FoodItem>();
			data = foodItems.getMenu();
			for(FoodItem item : data)
			{
				if(java.sql.Date.valueOf(item.getDate().toString()).equals(java.sql.Date.valueOf(today.toString())))
				{
					todayMenu.add(item);
				}
			}
			req.setAttribute("data", todayMenu);
			RequestDispatcher rd = req.getRequestDispatcher("CashierE_Menu.jsp");
			rd.forward(req, res);
		}
		catch(Exception e)
		{
			req.setAttribute("exception", e);
			RequestDispatcher rd = req.getRequestDispatcher("Error.jsp");
			rd.forward(req, res);
			e.printStackTrace();
		}
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		try 
		{
			Order order = null;
			ArrayList<Order> orders = new ArrayList<Order>();
			String foodItemOrdered = req.getParameter("foodItem");
			String amountOrdered = req.getParameter("amountOrdered");
			String staffPrice = req.getParameter("staffPrice");
			String studentPrice = req.getParameter("studentPrice");
//			String[] foodItems = req.getParameterValues("foodItem");
//			String[] staffPrices = req.getParameterValues("staffPrice");
//			String[] studentPrices = req.getParameterValues("studentPrice");
			// student order
			if(staffPrice == null)
			{
				order = new Order(foodItemOrdered, Integer.parseInt(amountOrdered), Float.parseFloat(studentPrice));
			}
			else if(studentPrice == null)
			{
				order = new Order(foodItemOrdered, Integer.parseInt(amountOrdered), Float.parseFloat(staffPrice));
			}
			System.out.println("Your order is"+"\t" +order.getFoodItem() + "\t" + order.getAmountOrdered() +"\t" + order.getCost());
			orders.add(order);
			HttpSession session = req.getSession();
			session.setAttribute("orders", orders);
			res.sendRedirect("cart");
		}
		catch(Exception e)
		{
			req.setAttribute("exception", e.getMessage());
			res.sendRedirect("Error.jsp");
			e.printStackTrace();
		}
		
	}
}