package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datastore.ChefDao;
import model.Chef;

@WebServlet("/registerChef")
public class RegisterChef extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		RequestDispatcher rd = req.getRequestDispatcher("NewChefAccount.jsp");
		rd.forward(req, res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	{
		try 
		{
			String fullname = req.getParameter("fullname");
			String email = req.getParameter("email");
			String employeeId = req.getParameter("employeeId");
			String nationalId = req.getParameter("nationalId");
			String phoneNumber = req.getParameter("phoneNumber");
			String password = req.getParameter("password");
			Chef chef = new Chef(fullname, email, nationalId, employeeId, phoneNumber, password);
			ChefDao chefDao = new ChefDao();
			chefDao.registerChef(chef);
			HttpSession session = req.getSession();
			session.setAttribute("chef", chef);
			res.sendRedirect("chefPortal");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}