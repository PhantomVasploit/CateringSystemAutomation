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

import datastore.CustomerDao;
import model.Customer;

@WebServlet("/customerlogin")
public class CustomerLogin extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		RequestDispatcher rd = req.getRequestDispatcher("CustomerLogin.jsp");
		rd.forward(req, res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			String regNo = req.getParameter("regNo");
			String password = req.getParameter("password");
			Customer customer = null;
			CustomerDao customerDao = new CustomerDao();
			customer = customerDao.customerLogin(regNo);
			// user check
			if(customer.equals(null))
			{
				String message = "Invalid Login Credentials";
				req.setAttribute("message", message);
				res.sendRedirect("customerlogin");
			}
			// password check
			StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
			if(passwordEncryptor.checkPassword(password, customer.getPassword()))
			{
				HttpSession session = req.getSession();
				session.setAttribute("customer", customer);
				res.sendRedirect("customerPortal");
			}
			else
			{
				String message = "Invalid Login Credentials";
				req.setAttribute("message", message);
				res.sendRedirect("customerlogin");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}