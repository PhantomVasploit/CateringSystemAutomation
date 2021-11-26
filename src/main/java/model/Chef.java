package model;

import java.io.Serializable;

import org.jasypt.util.password.StrongPasswordEncryptor;

public class Chef extends Employee implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Chef()
	{
		this.fullname = "";
		this.email = "";
		this.nationalId = "";
		this.employeeId = "";
		this.phoneNumber = "";
		this.password = "";
	}
	
	public Chef(String fullname, String email, String nationalId, String employeeId, String phoneNumber, String password)
	{
		StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
		String encryptedPassword = passwordEncryptor.encryptPassword(password);
		this.fullname = fullname;
		this.email = email;
		this.nationalId = nationalId;
		this.employeeId = employeeId;
		this.phoneNumber = phoneNumber;
		this.password = encryptedPassword;
	}
	
	// setters
	public void setFullName(String fullname)
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
	public void setNationalId(String nationalId)
	{
		this.nationalId = nationalId; 
	}
	public void setEmployeeId(String employeeId)
	{
		this.employeeId = employeeId; 
	}
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}
	
	//getters
	public String getFullName()
	{
		return fullname;
	}
	public String getEmail()
	{
		return email;
	}
	public String getNationalId()
	{
		return nationalId;
	}
	public String getEmployeeId()
	{
		return employeeId;
	}
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	public String getPassword()
	{
		return password;
	}
}