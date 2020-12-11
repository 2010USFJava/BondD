package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.beans.Reimbursement;
import com.revature.dao.EmployeeDAO;
import com.revature.dao.ReimbursementDAO;
import com.revature.service.EmployeeService;
import com.revature.utility.ConnFactory;
import com.revature.utility.LogIt;

public class ReimbursementDAOImpl implements ReimbursementDAO {
	
	public static ConnFactory cf=ConnFactory.getInstance();
	EmployeeDAO empDao = new EmployeeDAOImpl();
	EmployeeService eServ = new EmployeeService();
	
	static { 
		try {
			Class.forName("org.postgresql.Driver");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void submitReimbursement(Reimbursement form) {
		try {
			Connection conn = cf.getConnection();
			String sql = "INSERT INTO reimbursements VALUES (DEFAULT,?,?,TO_DATE(?,'DDMMYYYY'),TO_TIMESTAMP(?,'HH12:MI:SS'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, form.getEmpID());
			ps.setString(2, form.getEventName());
			ps.setString(3, form.getDate());
			ps.setString(4, form.getTime());
			ps.setString(5, form.getLocation());
			ps.setString(6, form.getLocation());
			ps.setString(7, form.getLocation());
			ps.setString(8, form.getDescription());
			ps.setDouble(9, form.getCost());
			ps.setString(10, form.getEventFile());
			ps.setString(11, form.getGradingFormat());
			ps.setString(12, form.getEventType());
			ps.setString(13, form.getJustification());
			ps.setString(14, form.getApprovalFile());
			ps.setInt(13, form.getDsApproval());
			ps.setInt(15, form.getDhApproval());
			ps.setBoolean(16, form.isBcApproval());
			ps.setDouble(16, form.getAlteredAmt());
			ps.setString(17, form.getAlteredReason());
			ps.setBoolean(18, form.isExceedingFunds());
			ps.setBoolean(19, form.isAwarded());
			ps.setString(20, form.getDenialReason());
			ps.execute();
		LogIt.logIt("info", "Reimbursement Request  for " + form.getEventName() + " has been requested by Employee: " + form.getEmpID() );

		} catch (SQLException e) {
			System.out.println("Check submitReimbursement() SQL "  +e.getSQLState() +" : "+ e.getMessage());
			e.printStackTrace();
		}
	}
}
