package model;

import java.io.Serializable;

public class Reciept implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String recieptNumber;
	private String transactionNumber;
	private String orderNumber;
	
	// constructors
	public Reciept()
	{
		this.recieptNumber = "";
		this.transactionNumber = "";
		this.orderNumber = "";
	}
	public Reciept(String recieptNumber, String transactionNumber, String orderNumber)
	{
		this.recieptNumber = recieptNumber;
		this.transactionNumber = transactionNumber;
		this.orderNumber = orderNumber;
	}
	
	//setters
	public void setTransactionNumber(String transactionNumber)
	{
		this.transactionNumber = transactionNumber;
	}
	public void setRecieptNumber(String recieptNumber)
	{
		this.recieptNumber = recieptNumber;
	}
	public void setOrderNumber(String orderNumber)
	{
		this.orderNumber = orderNumber;
	}
	
	// getters	
	public String getTransactionNumber()
	{
		return transactionNumber;
	}
	public String getRecieptNumber()
	{
		return recieptNumber;
	}
	public String getOrderNumber()
	{
		return orderNumber;
	}
}