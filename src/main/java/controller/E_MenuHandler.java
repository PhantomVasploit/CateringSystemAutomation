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

import datastore.FoodItemsDao;
import model.FoodItem;

@WebServlet("/e-menu")
public class E_MenuHandler extends HttpServlet {
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
			RequestDispatcher rd = req.getRequestDispatcher("E_Menu.jsp");
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

}