package model;

import java.io.Serializable;
import java.sql.Date;

public class E_Menu extends FoodItem implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String amountPrepared;
	private String date_code;
	public E_Menu()
	{
		this.itemCode = "";
		this.amountPrepared = "";
		this.date = null;
	}
	public E_Menu(String itemCode, String amountPrepared, Date date )
	{
		this.itemCode = itemCode;
		this.amountPrepared = amountPrepared;
		this.date = date;
		this.date_code = date.toString().concat("-").concat(itemCode);
	}
	
	// setters 
	public void setAmountPrepared(String amountPrepared)
	{
		this.amountPrepared = amountPrepared;
	}
	
	
	//getters
	public String getAmountPrepared()
	{
		return amountPrepared;
	}
	
	public String getDateCode()
	{
		return date_code;
	}
}