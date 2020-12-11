package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

public class EmployeePendingController {
	public EmployeePendingController() {
		super();
	}

	public static String pendingPage(HttpServletRequest req) {
		 return "HTML/EmpPortal/Pending.html";
	}
}
