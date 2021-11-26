package datastore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;

import model.Cashier;

public class CashierDao {
	String dbDriver = "com.mysql.cj.jdbc.Driver";
	String dbURL = "jdbc:mysql://127.0.0.1:3306/catering_department_database";
	String dbUsername = "Ph@ntomVasploit";
	String dbPassword = "pajoy9903";
	
	// cashier's CRUD
		@SuppressWarnings("deprecation")
		public int registerCashier(Cashier cashier) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException
		{
			int result = 0;
			String sqlQuery = "INSERT INTO cashier" + "(fullname, email, nationalId, employeeId, phoneNumber, password) VALUES" + "(?,?,?,?,?,?)";
			Class.forName(dbDriver).newInstance();
			try
				(
					Connection connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
					PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
				)
			{
				preparedStatement.setString(1, cashier.getFullName());
				preparedStatement.setString(2, cashier.getEmail());
				preparedStatement.setString(3, cashier.getNationalId());
				preparedStatement.setString(4, cashier.getEmployeeId());
				preparedStatement.setString(5, cashier.getPhoneNumber());
				preparedStatement.setString(6, cashier.getPassword());
				result = preparedStatement.executeUpdate();
				connection.close();
				preparedStatement.close();
			}
			
			return result;
		}
		
		public Cashier cashierLogin(String employeeId) throws ClassNotFoundException
		{
			Cashier cashier = null;
			String sqlQuery = "SELECT * FROM `cashier` WHERE employeeId = " + "'" +employeeId +"'";
			Class.forName(dbDriver);
			try
			{
				Connection connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery(sqlQuery);
				while(rs.next())
				{
					cashier = new Cashier(rs.getString("fullname"), rs.getString("email"), rs.getString("nationalId"), rs.getString("employeeId"), rs.getString("phoneNumber"), rs.getString("password"));
					System.out.println(cashier.getEmail());
				}
				
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			return cashier;
		}
}
