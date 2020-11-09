package com.revature.model;

import java.io.Serializable;
import java.util.List;

import com.revature.implementation.AccountImp;
import com.revature.implementation.EndUserImp;
import com.revature.utility.BankLogger;
import com.revature.utility.DataPersistenceUtility;

public class Customer extends EndUser implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7809550920827255123L;
	private int customerID;
	private String address;
	private String phoneNumber;
	private List<Integer> accountNumList;
	
	
	public Customer() {
		super();
		EndUserImp.getEndUserList().add(this);
		DataPersistenceUtility.writeUtility(EndUserImp.getEndUserList(), DataPersistenceUtility.getEnduserfile());
		BankLogger.LogIt("info","A new customer registered.");
	}
	
	public Customer(String fName, String lName, String userName, String password, boolean isActive, String status, int customerID, String address, String phoneNumber, 
			List<Integer> accountNumList) {
		super(fName, lName, userName, password, isActive, status);
		this.customerID = customerID;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.accountNumList = accountNumList;
		EndUserImp.getEndUserList().add(this);
		DataPersistenceUtility.writeUtility(EndUserImp.getEndUserList(), DataPersistenceUtility.getEnduserfile());
		BankLogger.LogIt("info","A new customer registered " + this.getUserName() +".");
	}
	

	
	public Customer(int customerID, String address, String phoneNumber, 
			List<Integer> accountNumList) {
		super();
		this.customerID = customerID;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.accountNumList = accountNumList;
		EndUserImp.getEndUserList().add(this);
		DataPersistenceUtility.writeUtility(EndUserImp.getEndUserList(), DataPersistenceUtility.getEnduserfile());
		BankLogger.LogIt("info","A new customer registered " + this.getUserName() +".");
	
	} 

	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<Integer> getAccountNumList() {
		return accountNumList;
	}

	public void setAccountNumList(List<Integer> accountNumList) {
		this.accountNumList = accountNumList;
	}

	@Override
	public String toString() {
		return  "Customer ID: " + customerID + ", Address: " + address + ", Phone Number:" + phoneNumber
				+ ", Account Number(s)" + accountNumList + ".\n";
	}
	
	
}
