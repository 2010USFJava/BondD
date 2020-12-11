package com.revature.beans;

public class Approver {
	
	private int approverID;
	private String userName;
	private String password;
	private String role;
	private String department;
	
	public int getApproverID() {
		return approverID;
	}
	public void setApproverID(int approverID) {
		this.approverID = approverID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public Approver() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Approver(int approverID, String userName, String password, String role, String department) {
		super();
		this.approverID = approverID;
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.department = department;
	}
	
	@Override
	public String toString() {
		return "Approver [approverID=" + approverID + ", userName=" + userName + ", password=" + password + ", role="
				+ role + ", department=" + department + "]";
	}
	
}
