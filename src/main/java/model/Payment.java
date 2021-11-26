package model;

import java.io.Serializable;

public class Payment implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String transactionNumber;
	private String transactionAmount;
	private String bankAccountNumber;
	private String customerRegNo;
	
	// constructors
	public Payment()
	{
		this.transactionNumber = "";
		this.transactionAmount = "";
		this.bankAccountNumber = "";
		this.customerRegNo = "";
	}
	public Payment(String transactionNumber, String transactionAmount, String bankAccountNumber, String customerRegNo)
	{
		this.transactionNumber = transactionNumber;
		this.transactionAmount = transactionAmount;
		this.bankAccountNumber = bankAccountNumber;
		this.customerRegNo = customerRegNo;
	}
	// setters
	public void setTransactionNumber(String transactionNumber)
	{
		this.transactionNumber = transactionNumber;
	}
	public void setTransactionAmount(String transactionAmount)
	{
		this.transactionAmount = transactionAmount;
	}
	public void setCost(String bankAcountNumber)
	{
		this.bankAccountNumber = bankAcountNumber;
	}
	public void customerRegNo(String customerRegNo)
	{
		this.customerRegNo = customerRegNo;
	}
	// getters
	public String getTransactionNumber()
	{
		return transactionNumber;
	}
	public String getTransactionAmount()
	{
		return transactionAmount;
	}
	public String getBankAccountNumber()
	{
		return bankAccountNumber;
	}
	public String getCustomerRegNo()
	{
		return customerRegNo;
	}
}