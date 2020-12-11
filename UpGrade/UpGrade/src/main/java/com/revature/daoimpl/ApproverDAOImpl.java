package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Approver;
import com.revature.dao.ApproverDAO;
import com.revature.utility.ConnFactory;
import com.revature.utility.LogIt;

public class ApproverDAOImpl implements ApproverDAO{
	public static ConnFactory cf= ConnFactory.getInstance();
	static {try {Class.forName("org.postgresql.Driver");
	}catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	}
	@Override
	public List<Approver> getAllApprovers() {
		List<Approver> appList = new ArrayList<Approver>();
		try {
			Connection conn = cf.getConnection();
			String sql = "SELECT * FROM approvers";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				appList.add(new Approver(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
			} 
		} catch (SQLException e) {
			System.out.println("Check getAllApprovers() SQL "  +e.getSQLState() +" : "+ e.getMessage());
				e.printStackTrace();
		}
		return appList;
	}

	@Override
	public void insertApprover(Approver app) {
		try {
			Connection conn = cf.getConnection();
			String sql = "INSERT INTO approvers values(?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, app.getApproverID());
			ps.setString(2, app.getUserName());
			ps.setString(3, app.getPassword());
			ps.setString(4, app.getRole());
			ps.setString(5, app.getDepartment());
			ps.execute();
			LogIt.logIt("info", "Approver " + app.getUserName()+  " has been created");
		} catch(SQLException e) {
				System.out.println("Check insertApprover() SQL "  +e.getSQLState() +" : "+ e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public Approver getApproverByUsername(String username) {
		Approver app = new Approver();
		try {
			Connection conn = cf.getConnection();
			String sql = "SELECT * FROM approvers WHERE username=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				app.setApproverID(rs.getInt(1));
				app.setUserName(rs.getString(2));
				app.setPassword(rs.getString(3));
				app.setRole(rs.getString(4));
				app.setDepartment(rs.getString(5));
			}
			} catch (SQLException e) {
				System.out.println("Check getApproverByUsername() SQL "  +e.getSQLState() +" : "+ e.getMessage());
				e.printStackTrace();
			}
			return app;
	}

}
