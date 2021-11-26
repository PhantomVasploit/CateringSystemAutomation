package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datastore.CashierDao;
import model.Cashier;

@WebServlet("/registerCashier")
public class RegisterCashier extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		RequestDispatcher rd = req.getRequestDispatcher("NewCashierAccount.jsp");
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
			Cashier cashier = new Cashier(fullname, email, nationalId, employeeId, phoneNumber, password);
			CashierDao cashierDao = new CashierDao();
			cashierDao.registerCashier(cashier);
			HttpSession session = req.getSession();
			session.setAttribute("cashier", cashier);
			res.sendRedirect("cashierPortal");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}