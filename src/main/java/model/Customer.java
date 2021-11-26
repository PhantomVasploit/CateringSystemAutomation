package model;

import java.io.Serializable;

import org.jasypt.util.password.StrongPasswordEncryptor;

public class Customer extends User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String regNo;
	// constructors
	public Customer()
	{
		this.fullname = "";
		this.email = "";
		this.password = "";
		this.phoneNumber = "";
		this.regNo = "";
	}
	public Customer(String fullname, String email, String regNo, String phoneNumber, String password)
	{
		StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
		String encryptedPassword = passwordEncryptor.encryptPassword(password);
		this.fullname = fullname;
		this.email = email;
		this.regNo = regNo;
		this.phoneNumber = phoneNumber;
		this.password = encryptedPassword;
	}
	
	public Customer(String fullname, String email, String regNo, String phoneNumber)
	{
		this.fullname = fullname;
		this.email = email;
		this.regNo = regNo;
		this.phoneNumber = phoneNumber;
	}
	// getters
	public String getFullName()
	{
		return fullname;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public String getRegistrationNumber()
	{
		return regNo;
	}
	
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	
	public String getPassword()
	{
		return password;
	}
	// setters
	public void setFullname(String fullname)
	{
		this.fullname = fullname;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public void setregistrationNumber(String regNo)
	{
		this.regNo = regNo;
	}
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}
}