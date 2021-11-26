package model;


import java.io.Serializable;
import java.time.LocalDateTime;

public class Order implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String orderNumber;
	private String foodItemName;
	private int amountOrdered;
	private float cost;
	private LocalDateTime dateAndTime = LocalDateTime.now();;
	
	// constructors
	public Order()
	{
		this.orderNumber = "";
		this.foodItemName = "";
		this.amountOrdered  = 0;
		this.cost = 0;
		this.dateAndTime = null;
	}
	public Order(String foodItemName, int amountOrdered, float cost)
	{
		this.orderNumber = foodItemName.concat("-").concat(dateAndTime.toString());
		this.foodItemName = foodItemName;
		this.amountOrdered = amountOrdered;
		float totalCost = cost * amountOrdered;
		this.cost = totalCost;
	}
	
	//setters
	public void setOrderNumber(String orderNumber)
	{
		this.orderNumber = orderNumber;
	}
	public void setFoodItem(String foodItemName)
	{
		this.foodItemName = foodItemName;
	}
	public void setCost(float cost)
	{
		this.cost = cost;
	}
	public void setAmountOrdered(int amountOrdered)
	{
		this.amountOrdered = amountOrdered;
	}
	public void setDateAndTime(LocalDateTime dateAndTime)
	{
		this.dateAndTime = dateAndTime;
	}
	
	// getters
	public String getOrderNumber()
	{
		return orderNumber;
	}
	public String getFoodItem()
	{
		return foodItemName;
	}
	public float getCost()
	{
		return cost;
	}
	public int getAmountOrdered()
	{
		return amountOrdered;
	}
	public LocalDateTime getDateAndTime()
	{
		return dateAndTime;
	}
}