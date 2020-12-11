package com.revature.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import com.revature.beans.Approver;
import com.revature.service.ApproverService;
import com.revature.utility.LogIt;

public class AppLoginController {
	static ApproverService aServ = new ApproverService();
	
	public static String login(HttpServletRequest req) throws SQLException {
		if(!req.getMethod().equals("POST")) {
			return "HTML/Login/AdminLogin.html";
		}
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		Approver app = aServ.loginGetApp(username, password);
		if(app==null) {
			return "wrongcreds.change";
		} else {
			req.getSession().setAttribute("activeapp", app);
			LogIt.logIt("info", "Approver " + app.getUserName()+ " successfully logged in.");
			return "apphome.change";
		}
		
	}
}
