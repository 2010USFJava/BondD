package com.revature.service;

import java.util.List;

import com.revature.beans.Approver;
import com.revature.dao.ApproverDAO;
import com.revature.daoimpl.ApproverDAOImpl;

public class ApproverService {

	public ApproverService() {
		super();
	}
	
	ApproverDAO appDao = new ApproverDAOImpl();
	
	public boolean loginVerify(String username, String password) {
		List<Approver> appList = appDao.getAllApprovers();
		boolean verify=false;
		for (Approver approver : appList) {
			if(approver.getUserName().equals(username)&&approver.getPassword().equals(password)) {
				verify=true;
			}
		}
		return verify;
	}
	
	public Approver loginGetApp(String username, String password) {
		if(loginVerify(username,password)) {
			return appDao.getApproverByUsername(username);
		}
		return null;
	}
	
	public void insertNewApp(Approver app) {
		appDao.insertApprover(app);
	}
}
