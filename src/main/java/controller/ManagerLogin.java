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

import datastore.ManagerDao;
import model.Manager;

@WebServlet("/managerlogin")
public class ManagerLogin extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		RequestDispatcher rd = req.getRequestDispatcher("ManagerLogin.jsp");
		rd.forward(req, res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			Manager manager = null;
			String employeeId = req.getParameter("employeeId");
			String password = req.getParameter("password");
			ManagerDao managerDao = new ManagerDao();
			manager = managerDao.managerLogin(employeeId);
			// check user
			if(manager.equals(null))
			{
				String message = "Invalid Login Credentials";
				req.setAttribute("message", message);
				res.sendRedirect("managerlogin");
			}
			// perform password check
			StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
			String encryptedPassword = passwordEncryptor.encryptPassword(password);
			System.out.println(encryptedPassword);
			System.out.println(manager.getPassword());
			System.out.println(passwordEncryptor.checkPassword(password, manager.getPassword()));
			if(passwordEncryptor.checkPassword(password, manager.getPassword()))
			{
				// create a session if password matches
				HttpSession session = req.getSession();
				session.setAttribute("manager", manager);
				res.sendRedirect("managerPortal");
			}
			else
			{
				String message = "Invalid Login Credentials";
				req.setAttribute("message", message);
				res.sendRedirect("managerlogin");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}