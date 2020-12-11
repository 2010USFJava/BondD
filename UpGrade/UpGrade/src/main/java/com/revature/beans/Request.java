package com.revature.beans;

public class Request {
	
	private int requestID;
	private int reimbursementID;
	private int dsID;
	private int dhID;
	private int empID;
	
	private String request;
	private String fulfilledRequest;
	
	public int getRequestID() {
		return requestID;
	}
	public void setRequestID(int requestID) {
		this.requestID = requestID;
	}
	public int getReimbursementID() {
		return reimbursementID;
	}
	public void setReimbursementID(int reimbursementID) {
		this.reimbursementID = reimbursementID;
	}
	public int getDsID() {
		return dsID;
	}
	public void setDsID(int dsID) {
		this.dsID = dsID;
	}
	public int getDhID() {
		return dhID;
	}
	public void setDhID(int dhID) {
		this.dhID = dhID;
	}
	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	public String getFulfilledRequest() {
		return fulfilledRequest;
	}
	public void setFulfilledRequest(String fulfilledRequest) {
		this.fulfilledRequest = fulfilledRequest;
	}
	
	public Request() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Request(int requestID, int reimbursementID, int dsID, int dhID, int empID, String request,
			String fulfilledRequest) {
		super();
		this.requestID = requestID;
		this.reimbursementID = reimbursementID;
		this.dsID = dsID;
		this.dhID = dhID;
		this.empID = empID;
		this.request = request;
		this.fulfilledRequest = fulfilledRequest;
	}
	
	@Override
	public String toString() {
		return "Request [requestID=" + requestID + ", reimbursementID=" + reimbursementID + ", dsID=" + dsID + ", dhID="
				+ dhID + ", empID=" + empID + ", request=" + request + ", fulfilledRequest=" + fulfilledRequest + "]";
	}

}
