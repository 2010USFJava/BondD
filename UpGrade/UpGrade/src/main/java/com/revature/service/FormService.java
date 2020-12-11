package com.revature.service;

import com.revature.dao.ReimbursementDAO;
import com.revature.daoimpl.ReimbursementDAOImpl;

public class FormService {
	public FormService() {
		super();
	}
	
	ReimbursementDAO formDao = new ReimbursementDAOImpl();
}
