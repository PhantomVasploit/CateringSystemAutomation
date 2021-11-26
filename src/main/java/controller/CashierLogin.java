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

import datastore.CashierDao;
import model.Cashier;

@WebServlet("/cashierlogin")
public class CashierLogin extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		RequestDispatcher rd = req.getRequestDispatcher("CashierLogin.jsp");
		rd.forward(req, res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			Cashier cashier = null;
			CashierDao cashierDao = new CashierDao();
			String employeeId = req.getParameter("employeeId");
			String password = req.getParameter("password");
			cashier = cashierDao.cashierLogin(employeeId);
			// check user
			if(cashier.equals(null))
			{
				String message = "Invalid Login Credentials";
				req.setAttribute("message", message);
				res.sendRedirect("cashierlogin");
			}
			// password check 
			StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
			if(passwordEncryptor.checkPassword(password, cashier.getPassword()))
			{
				// true create a session for the cashier
				HttpSession session = req.getSession();
				session.setAttribute("cashier", cashier);
				RequestDispatcher rd = req.getRequestDispatcher("cashierPortal");
				rd.forward(req, res);
			}
			else
			{
				String message = "Invalid login credentials";
				req.setAttribute("message", message);
				res.sendRedirect("cashierlogin");
			}
			// create session for cashier
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
				
		
	}
}