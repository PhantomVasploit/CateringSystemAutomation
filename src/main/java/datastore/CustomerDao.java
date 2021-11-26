package datastore;

import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import model.Customer;


public class CustomerDao 
{
	String dbDriver = "com.mysql.cj.jdbc.Driver";
	String dbURL = "jdbc:mysql://127.0.0.1:3306/catering_department_database";
	String dbUsername = "Ph@ntomVasploit";
	String dbPassword = "pajoy9903";
//Customer's CRUD
	@SuppressWarnings("deprecation")
	public int registerCustomer(Customer customer) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		String INSERT_CUSTOMER_SQL = "INSERT INTO customer" + "(fullname, email, registrationNumber, phoneNumber, password) VALUES" + "(?,?,?,?,?)";
		int result = 0;
		Class.forName(dbDriver).newInstance();
		try
			(
				Connection connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER_SQL);
			)
			{
				preparedStatement.setString(1, customer.getFullName());
				preparedStatement.setString(2,  customer.getEmail());
				preparedStatement.setString(3, customer.getRegistrationNumber());
				preparedStatement.setString(4, customer.getPhoneNumber());
				preparedStatement.setString(5, customer.getPassword());
				System.out.println(preparedStatement);
				result = preparedStatement.executeUpdate();
				preparedStatement.close();
				connection.close();
			}catch(SQLException e) 
			{
				e.printStackTrace();
			}
			System.out.println(result);
		return result;
	}
	
	public ArrayList<Customer> getCustomerData() throws ClassNotFoundException
	{
		ArrayList<Customer> data = new ArrayList<Customer>();
		String sqlQuery = "SELECT * FROM customer";
		Class.forName(dbDriver);
		try 
		{
			Connection connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sqlQuery);
			while(rs.next())
			{
				System.out.println(rs.getString("fullname") + "\t" + rs.getString("email") + "\t" + rs.getString("registrationNumber") + "\t" + rs.getString("PhoneNumber"));
				String fullname = rs.getString("fullname");
				String email = rs.getString("email");
				String registrationNumber = rs.getString("registrationNumber");
				String phoneNumber = rs.getString("PhoneNumber");
				Customer customer = new Customer(fullname, email, registrationNumber, phoneNumber);
				data.add(customer);
			}
			connection.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return data;

	}
	public Customer customerLogin(String regNo) throws ClassNotFoundException
	{
		Customer customer = null;
		String sqlQuery = "SELECT * FROM customer WHERE regNo = " + regNo;
		
		Class.forName(dbDriver);
		try 
		{
			Connection connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sqlQuery);
			customer = new Customer(rs.getString("fullname"), rs.getString("email"), rs.getString("regNo"), rs.getString("phoneNumber"), rs.getString("password"));
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return customer;
	}
// update customer details
//	public Customer customerUpdate(String registrationNumber, String password) throws ClassNotFoundException
//	{
//		Customer customer = null;
//		String sqlQuery = "";
//		Class.forName(dbDriver);
//		return customer;
//	}
//// delete customer details
//	public Customer customerDelete(String regNo)
//	{
//		Customer customer = null;
//		String sqlQuery = "DELETE FROM customer WHERE registrationNumber = " + '"'+ regNo + '"';
//		try
//		{
//			Connection connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
//			Statement statement =  connection.createStatement();
//			
//		}
//		catch(SQLException e)
//		{
//			e.printStackTrace();
//		}
//		return customer;
//	}
}