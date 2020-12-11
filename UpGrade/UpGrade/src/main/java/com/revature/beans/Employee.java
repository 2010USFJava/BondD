package com.revature.beans;

public class Employee {
	
	private int empID;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private double availableR;
	private int supervisorID;
	private int deptHeadID;

	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	public double getAvailableR() {
		return availableR;
	}
	public void setAvailableR(double availableR) {
		this.availableR = availableR;
	}
	public int getSupervisorID() {
		return supervisorID;
	}
	public void setSupervisorID(int supervisorID) {
		this.supervisorID = supervisorID;
	}
	public int getDeptHeadID() {
		return deptHeadID;
	}
	public void setDeptHeadID(int deptHeadID) {
		this.deptHeadID = deptHeadID;
	}
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Employee(int empID, String firstName, String lastName, String userName, String password, double availableR,
			int supervisorID, int deptHeadID) {
		super();
		this.empID = empID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.availableR = availableR;
		this.supervisorID = supervisorID;
		this.deptHeadID = deptHeadID;
	}
	
	@Override
	public String toString() {
		return "Employee [empID=" + empID + ", firstName=" + firstName + ", lastName=" + lastName + ", userName="
				+ userName + ", password=" + password + ", availableR=" + availableR + ", supervisorID=" + supervisorID
				+ ", deptHeadID=" + deptHeadID + "]";
	}
}
