package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datastore.CustomerDao;
import model.Customer;

@WebServlet("/registerCustomer")
public class RegisterCustomer extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CustomerDao db = new CustomerDao();
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	{
		String fullname = req.getParameter("fullname");
		String email = req.getParameter("email");
		String registrationNumber = req.getParameter("registrationNumber");
		String phoneNumber = req.getParameter("phoneNumber");
		String password = req.getParameter("password");
		
		Customer customer = new Customer(fullname, email, registrationNumber, phoneNumber, password);
		try {
			db.registerCustomer(customer);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		RequestDispatcher rd = req.getRequestDispatcher("NewCustomerAccount.jsp");
		rd.forward(req, res);
	}
}
