package com.revature.controller;
import javax.servlet.http.HttpServletRequest;

public class EmployeePortalController {

	public EmployeePortalController() {
		super();
		
	}
	
	public static String home(HttpServletRequest req) {
		return "HTML/EmpPortal/EmpPortal.html";
	}
}
