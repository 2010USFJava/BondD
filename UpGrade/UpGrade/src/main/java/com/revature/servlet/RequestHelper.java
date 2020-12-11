package com.revature.servlet;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import com.revature.controller.AppLoginController;
import com.revature.controller.ApprovalPortalController;
import com.revature.controller.EmpLoginController;
import com.revature.controller.EmployeeFormController;
import com.revature.controller.EmployeePendingController;
import com.revature.controller.EmployeePortalController;

public class RequestHelper {

	public static String process(HttpServletRequest req) {
		
		System.out.println(req.getRequestURI());
		try {
			switch(req.getRequestURI()) {
			case "/UpGrade/emplogin.change":
				System.out.println("in login.change rhelper");
				return EmpLoginController.login(req);
			case "/UpGrade/emphome.change":
				System.out.println("in home.change rhelper");
				return EmployeePortalController.home(req);
			case "/UpGrade/applogin.change":
				System.out.println("in login.change rhelper");
				return AppLoginController.login(req);
			case "/UpGrade/apphome.change":
				System.out.println("in home.change rhelper");
				return ApprovalPortalController.home(req);
			case "/UpGrade/empForm.change":
				System.out.println("in empForm.change");
				return EmployeeFormController.submission(req);
			case "/UpGrade/pending.change":
				System.out.println("in pending.change");
				return EmployeePendingController.pendingPage(req);
			default:
				System.out.println("in default case");
			
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return "HTML/unsuccesfullogin.html";
	}

}
