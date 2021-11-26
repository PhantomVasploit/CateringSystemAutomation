package datastore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.*;

import model.Manager;

public class ManagerDao {
	String dbDriver = "com.mysql.cj.jdbc.Driver";
	String dbURL = "jdbc:mysql://127.0.0.1:3306/catering_department_database";
	String dbUsername = "Ph@ntomVasploit";
	String dbPassword = "pajoy9903";
	// Manager's CRUD
		@SuppressWarnings("deprecation")
		public int registerManager(Manager manager) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
		{
			int result = 0;
			String sqlQuery = "INSERT INTO manager" +" (fullname, email, nationalId, employeeId, phoneNumber, password) VALUES"+ "(?,?,?,?,?,?)";
			Class.forName(dbDriver).newInstance();
			try(
					Connection connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
					PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
					)
			
			{
				preparedStatement.setString(1, manager.getFullname());
				preparedStatement.setString(2, manager.getEmail());
				preparedStatement.setString(3, manager.getNationalId());
				preparedStatement.setString(4, manager.getEmployeeId());
				preparedStatement.setString(5, manager.getPhoneNumber());
				preparedStatement.setString(6, manager.getPassword());
				result = preparedStatement.executeUpdate();
				connection.close();
				preparedStatement.close();
			}
			return result;
		}
		
		@SuppressWarnings("deprecation")
		public Manager managerLogin(String employeeId) throws InstantiationException, IllegalAccessException, ClassNotFoundException
		{
			Manager manager = null;
			String sqlQuery = "SELECT * FROM `manager` WHERE employeeId = " + "'" +employeeId +"'";
			Class.forName(dbDriver).newInstance();
			try
			{
				System.out.println( employeeId +"\n");
				Connection connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery(sqlQuery);
				while(rs.next())
				{
					manager = new Manager(rs.getString("fullname"), rs.getString("email"), rs.getString("nationalId"), rs.getString("employeeId"), rs.getString("phoneNumber"), rs.getString("password"));
					System.out.println(manager.getEmail());
				}
				
				connection.close();
				statement.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			
			return manager;
		}
		

		

}