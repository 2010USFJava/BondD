package com.revature.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Approver;

public class ApproverController {
	public static void getSessionEmp(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException {
		Approver app= (Approver) req.getSession().getAttribute("activeapp");
		res.getWriter().write(new ObjectMapper().writeValueAsString(app));
	}
}
