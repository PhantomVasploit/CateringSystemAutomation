package model;

import java.io.Serializable;
import java.sql.Date;

public class FoodItem implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String itemName;
	protected String itemCode;
	private String staffCafeteriaPrice;
	private String studentCafeteriaPrice;
	protected Date date;
	// constructors
	public FoodItem()
	{
		this.itemCode = "";
		this.itemName = "";
		this.staffCafeteriaPrice = "";
		this.studentCafeteriaPrice = "";
		this.date = null;
	}
	public FoodItem(String itemName, String itemCode, String staffCafeteriaPrice, String studentCafeteriaPrice)
	{
		this.itemName = itemName;
		this.itemCode = itemCode;
		this.staffCafeteriaPrice = staffCafeteriaPrice;
		this.studentCafeteriaPrice = studentCafeteriaPrice;
	}
	public FoodItem(String itemName, String staffCafeteriaPrice, String studentCafeteriaPrice, Date date)
	{
		this.itemName = itemName;
		this.date = date;
		this.staffCafeteriaPrice = staffCafeteriaPrice;
		this.studentCafeteriaPrice = studentCafeteriaPrice;
	}
	public FoodItem(String itemName, String staffCafeteriaPrice, String studentCafeteriaPrice)
	{
		this.itemName = itemName;
		this.staffCafeteriaPrice = staffCafeteriaPrice;
		this.studentCafeteriaPrice = studentCafeteriaPrice;
	}
	
	// setter
	public void setItemName(String itemName)
	{
		this.itemName = itemName;
	}
	public void setItemCode(String itemCode)
	{
		this.itemCode = itemCode;
	}
	public void setDate(Date date)
	{
		this.date = date;
	}
	public void setStaffCafeteriaPrice(String staffCafeteriaPrice)
	{
		this.staffCafeteriaPrice = staffCafeteriaPrice;
	}
	public void setStudentCafeteriaPrice(String studentCafeteriaPrice)
	{
		this.studentCafeteriaPrice = studentCafeteriaPrice;
	}
	//getters 
	public String getItemName()
	{
		return itemName;
	}
	public String getItemCode()
	{
		return itemCode;
	}
	public String getStaffCafeteriaPrice()
	{
		return staffCafeteriaPrice;
	}
	public String getStudentCafeteriaPrice()
	{
		return studentCafeteriaPrice;
	}
	public Date getDate()
	{
		return date;
	}
}