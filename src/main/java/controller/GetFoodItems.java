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
import model.E_Menu;
import model.FoodItem;

@WebServlet("/food-items")
public class GetFoodItems extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		FoodItemsDao foodItems = new FoodItemsDao();
		try {
			ArrayList<FoodItem> data = foodItems.getFoodItems();
			req.setAttribute("foodItems", data);
			RequestDispatcher rd = req.getRequestDispatcher("FoodItems.jsp");
			rd.forward(req, res);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			java.util.Date date = new Date();
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			FoodItemsDao foodList = new FoodItemsDao();
			ArrayList<FoodItem> data = foodList.getFoodItems();
			String foodItem = req.getParameter("foodItem");
			System.out.println(foodItem);
			String amountPrepared = req.getParameter("amountPrepared");
			System.out.println(amountPrepared);
		
			for(FoodItem item : data)
			{
				if(foodItem.equals(item.getItemName()))
				{
					E_Menu e_menu = new E_Menu(item.getItemCode(), amountPrepared, sqlDate);
					foodList.createEMenu(e_menu);
					System.out.println(e_menu.getItemCode() + "\t" + e_menu.getAmountPrepared() + "\t" + e_menu.getDate() + "\n");
					
				}
			}
			res.sendRedirect("food-items");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}