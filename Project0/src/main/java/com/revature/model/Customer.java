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
	
	
	
	public Customer() {
		super();
		
		
	}
	
	public Customer(String fName, String lName, String userName, String password, boolean isActive,  int customerID, String address, String phoneNumber 
			) {
		super(fName, lName, userName, password, isActive);
		this.customerID = customerID;
		this.address = address;
		this.phoneNumber = phoneNumber;
		
		
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

	
	@Override
	public String toString() {
		return  "Customer ID: " + customerID + ", Address: " + address + ", Phone Number:" + phoneNumber
				+ ".";
	}
	
	
}
