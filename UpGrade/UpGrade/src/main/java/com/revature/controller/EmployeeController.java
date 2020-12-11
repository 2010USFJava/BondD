package com.revature.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.revature.beans.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.service.EmployeeService;

public class EmployeeController {
	static EmployeeService eServ = new EmployeeService();
	
	public static void getSessionEmp(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException {
		HttpSession session = req.getSession();
		int emp= (int) session.getAttribute("activeemp");
		Employee empObj = eServ.getSessionEmp(emp);
		System.out.println("in employee controller");
		System.out.println(empObj);
		ObjectMapper mapper = new ObjectMapper ();
		String empString = mapper.writeValueAsString(empObj);
		String newString = "{\"employee\":" + empString + "}";
		System.out.println(newString);
		res.getWriter().write(newString);
	}
}
