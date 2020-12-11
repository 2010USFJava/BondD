package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

public class ApprovalPortalController {

	public ApprovalPortalController() {
		super();
	}
	
	public static String home(HttpServletRequest req) {
		return "HTML/AdminPortal/BenCoPortal.html";
	}
}
