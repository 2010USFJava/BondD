package com.revature.model;

import java.io.Serializable;

public abstract class EndUser implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7847898838484590877L;
	private String fName;
	private String lName;
	private String UserName;
	private String password;
	private boolean isActive;
	private String status; // can only be CUSTOMER, EMPLOYEE, or ADMIN
	
	public EndUser() {
		super();
	}
	public EndUser(String fName, String lName, String userName, String password, boolean isActive) {
		
		this.fName = fName;
		this.lName = lName;
		UserName = userName;
		this.password = password;
		this.isActive = isActive;
		
	} 
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	public String toString() {
		return "EndUser [fName=" + fName + ", lName=" + lName + ", UserName=" + UserName + ", password=" + password
				+ ", isActive=" + isActive +  "]";
	}
	
	

}

