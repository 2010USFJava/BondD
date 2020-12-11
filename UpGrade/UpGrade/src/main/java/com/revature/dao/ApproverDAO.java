package com.revature.dao;

import java.util.List;

import com.revature.beans.Approver;

public interface ApproverDAO {
	public List<Approver> getAllApprovers();
	public void insertApprover(Approver app);
	public Approver getApproverByUsername(String username);
}
