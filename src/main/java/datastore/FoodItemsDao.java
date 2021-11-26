package datastore;

import java.util.ArrayList;
import java.sql.*;

import model.E_Menu;
import model.FoodItem;

public class FoodItemsDao {
	String dbDriver = "com.mysql.cj.jdbc.Driver";
	String dbURL = "jdbc:mysql://127.0.0.1:3306/catering_department_database";
	String dbUsername = "Ph@ntomVasploit";
	String dbPassword = "pajoy9903";
	
	public ArrayList<FoodItem> getFoodItems() throws ClassNotFoundException
	{
        ArrayList<FoodItem> data = new ArrayList<>();
		String sqlQuery = "SELECT * FROM food_items";
		Class.forName(dbDriver);
		try
		{
			Connection connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sqlQuery);
			while(rs.next())
			{
				FoodItem foodItems = new FoodItem(rs.getString("item_name"), rs.getString("item_code"), rs.getString("staff_cafeteria_price"), rs.getString("student_cafeteria_price"));
				data.add(foodItems);
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return data;
	}
	public int createEMenu(E_Menu e_menu) throws SQLException
	{
		int result = 0;
		String sqlQuery = "INSERT INTO e_menu(amount_prepared, date_code , date, item_code) VALUES (?,?,?,?)";
		try
		(
				Connection connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
				PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
				)
		{
			preparedStatement.setString(1, e_menu.getAmountPrepared());
			preparedStatement.setString(2,  e_menu.getDateCode());
			preparedStatement.setDate(3, (Date) e_menu.getDate());
			preparedStatement.setString(4 , e_menu.getItemCode());
			result = preparedStatement.executeUpdate();
		}
		return result;
	}
	

		
	public ArrayList<FoodItem> getMenu() throws ClassNotFoundException
	{
		ArrayList<FoodItem> data = new ArrayList<FoodItem>();
		String sqlQuery = "SELECT Item_name,staff_cafeteria_price, student_cafeteria_price, date ,date_code FROM food_items INNER JOIN e_menu ON food_items.item_code = e_menu.item_code ";
		Class.forName(dbDriver);
		try
		{
			Connection connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sqlQuery);
			while(rs.next())
			{
				FoodItem foodItem = new FoodItem(rs.getString("item_name"), rs.getString("staff_cafeteria_price"), rs.getString("student_cafeteria_price"), rs.getDate("date"));
				data.add(foodItem);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return data;
	}
}