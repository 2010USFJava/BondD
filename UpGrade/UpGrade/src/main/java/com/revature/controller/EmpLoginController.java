package com.revature.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.revature.beans.Employee;
import com.revature.service.EmployeeService;
import com.revature.utility.LogIt;

public class EmpLoginController {
	static EmployeeService eServ = new EmployeeService();
	
	public static String login(HttpServletRequest req) throws SQLException {
		if(!req.getMethod().equals("POST")) {
			return "HTML/Login/EmpLogin.html";
		}
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		Employee emp = eServ.loginGetEmp(username, password);
		if(emp==null) {
			return "wrongcreds.change";
		} else {
			HttpSession session = req.getSession();
			session.setAttribute("activeemp", emp.getEmpID());
			System.out.println();

	   		LogIt.logIt("info", "Employee " + emp.getFirstName()+ " "+ emp.getLastName()+ " successfully logged in.");
			return "emphome.change";
		}
	}
}
