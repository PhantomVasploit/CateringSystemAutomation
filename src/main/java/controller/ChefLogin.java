package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jasypt.util.password.StrongPasswordEncryptor;

import datastore.ChefDao;
import model.Chef;

@WebServlet("/cheflogin")
public class ChefLogin extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		RequestDispatcher rd = req.getRequestDispatcher("ChefLogin.jsp");
		rd.forward(req, res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			ChefDao chefDao = new ChefDao();
			Chef chef = null;
			String employeeId = req.getParameter("employeeId");
			String password = req.getParameter("password");
			chef = chefDao.chefLogin(employeeId);
			// check user
			if (chef.equals(null))
			{
				String message = "Invalid Login Credentials";
				req.setAttribute("message", message);
				res.sendRedirect("cheflogin");
			}
			// password check
			StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
			if(passwordEncryptor.checkPassword(password, chef.getPassword()))
			{
				HttpSession session = req.getSession();
				session.setAttribute("chef", session);
				res.sendRedirect("chefPortal");
			}
			else
			{
				String message = "Invalid login credentials";
				req.setAttribute("message", message);
				res.sendRedirect("cheflogin");
			}
			// create session
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			
	}
}