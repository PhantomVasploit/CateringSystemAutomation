package datastore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

import model.Chef;


public class ChefDao {
	String dbDriver = "com.mysql.cj.jdbc.Driver";
	String dbURL = "jdbc:mysql://127.0.0.1:3306/catering_department_database";
	String dbUsername = "Ph@ntomVasploit";
	String dbPassword = "pajoy9903";
	
	// chef's CRUD
		@SuppressWarnings("deprecation")
		public int registerChef(Chef chef) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
		{
			int result = 0;
			String sqlQuery = "INSERT INTO chef" + "(fullname, email, nationalId, employeeId, phoneNumber, password) VALUES" + "(?,?,?,?,?,?)";
			Class.forName(dbDriver).newInstance();
			try
			(
					Connection connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
					PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
					)
			{
				preparedStatement.setString(1, chef.getFullName());
				preparedStatement.setString(2, chef.getEmail());
				preparedStatement.setString(3, chef.getNationalId());
				preparedStatement.setString(4, chef.getEmployeeId());
				preparedStatement.setString(5, chef.getPhoneNumber());
				preparedStatement.setString(6, chef.getPassword());
				result = preparedStatement.executeUpdate();
				connection.close();
				preparedStatement.close();
			}catch( SQLException e)
			{
				e.printStackTrace();
			}
			return result;
		}
		
		@SuppressWarnings("deprecation")
		public Chef chefLogin(String employeeId) throws InstantiationException, IllegalAccessException, ClassNotFoundException
		{
			Chef chef = null;
			String sqlQuery = "SELECT * FROM `chef` WHERE employeeId = " + "'" +employeeId +"'";
			Class.forName(dbDriver).newInstance();
			try
			{
				Connection connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery(sqlQuery);
				while(rs.next())
				{
					chef = new Chef(rs.getString("fullname"), rs.getString("email"), rs.getString("nationalId"), rs.getString("employeeId"), rs.getString("phoneNumber"), rs.getString("password"));
					System.out.println(chef.getEmail());
				}
				
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		
			return chef;
		}
		

}