package com.revature.servlet;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.revature.controller.EmployeeController;

public class JSONRequestHelper{
	public static void process(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException {
		switch(req.getRequestURI()) {
		case "/UpGrade/getsession.json":
			System.out.println("in request helper");
			EmployeeController.getSessionEmp(req, res);
		}
		
	}
}
