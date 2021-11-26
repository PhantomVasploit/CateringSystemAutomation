package datastore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Order;

public class OrderProcessingDao {
	String dbDriver = "com.mysql.cj.jdbc.Driver";
	String dbURL = "jdbc:mysql://127.0.0.1:3306/catering_department_database";
	String dbUsername = "Ph@ntomVasploit";
	String dbPassword = "pajoy9903";
	
	public int addOrder(Order order) throws ClassNotFoundException, SQLException
	{
		int result = 0;
		String sqlQuery = "INSERT INTO orders (orderNumber, foodItemName, amountOrdered, cost) VALUES (?,?,?,?)";
		Class.forName(dbDriver);
		try
		(
				Connection connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
				PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
		)
		{
			preparedStatement.setString(1, order.getOrderNumber());
			preparedStatement.setString(2, sqlQuery);
		}
		return result;
	}
}