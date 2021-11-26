package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datastore.ManagerDao;
import model.Manager;

@WebServlet("/registerManager")
public class RegisterManager extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		RequestDispatcher rd = req.getRequestDispatcher("NewManagerAccount.jsp");
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
			System.out.println(password);
			Manager manager = new Manager(fullname, email, nationalId, employeeId, phoneNumber ,password);
			ManagerDao managerDao = new ManagerDao();
			managerDao.registerManager(manager);
			// creating manager session
			HttpSession session = req.getSession();
			session.setAttribute("manager", manager);
			res.sendRedirect("managerPortal");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}