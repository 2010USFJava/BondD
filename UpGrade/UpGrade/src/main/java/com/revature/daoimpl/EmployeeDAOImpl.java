package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Employee;
import com.revature.dao.EmployeeDAO;
import com.revature.utility.ConnFactory;
import com.revature.utility.LogIt;

public class EmployeeDAOImpl implements EmployeeDAO {
	public static ConnFactory cf=ConnFactory.getInstance();
	static {
		try { Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
	}
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> empList = new ArrayList<Employee>();
		try {
			Connection conn = cf.getConnection();
			String sql = "SELECT * FROM employees";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				empList.add(new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getDouble(6),rs.getInt(7),rs.getInt(8)));
			}
		} catch (SQLException e) {
			System.out.println("Check getAllEmployee() SQL "  +e.getSQLState() +" : "+ e.getMessage());
			e.printStackTrace();
		}
		return empList;
	}

	@Override
	public void insertEmployee(Employee emp) {	
		try {
			Connection conn = cf.getConnection();
			String sql = "INSERT INTO employees values(?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, emp.getEmpID());
			ps.setString(2, emp.getFirstName());
			ps.setString(3, emp.getLastName());
			ps.setString(4, emp.getUserName());
			ps.setString(5, emp.getPassword());
			ps.setDouble(6, emp.getAvailableR());
			ps.setInt(7, emp.getSupervisorID());
			ps.setInt(8, emp.getDeptHeadID());
			ps.execute();
			LogIt.logIt("info", "Employee " + emp.getFirstName()+ " "+ emp.getLastName()+ " has been created");
		} catch (SQLException e) { 
			System.out.println("Check insertEmployee() SQL "  +e.getSQLState() +" : "+ e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public Employee getEmployeeByUsername(String username) {
		Employee emp = new Employee();
		PreparedStatement ps;
		try {
			Connection conn = cf.getConnection();
			String sql = "SELECT * FROM employees WHERE username=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				emp.setEmpID(rs.getInt(1));
				emp.setFirstName(rs.getString(2));
				emp.setLastName(rs.getString(3));
				emp.setUserName(rs.getString(4));
				emp.setPassword(rs.getString(5));
				emp.setAvailableR(rs.getDouble(6));
				emp.setSupervisorID(rs.getInt(7));
				emp.setDeptHeadID(rs.getInt(8));
			}
		} catch (SQLException e) {
			System.out.println("Check getEmployeeByUsername() SQL "  +e.getSQLState() +" : "+ e.getMessage());
			e.printStackTrace();
		}
		return emp;
	}
	
	@Override
	public Employee getEmployeeById(int empID) {
		PreparedStatement ps;
		Employee emp = null;
		try {
			Connection conn = cf.getConnection();
			String sql = "SELECT * FROM employees WHERE empid=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, empID);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				emp = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDouble(6), rs.getInt(7), rs.getInt(8));
				
			}
			
		} catch (SQLException e) {
			System.out.println("Check getEmployeeByID() SQL "  +e.getSQLState() +" : "+ e.getMessage());
			e.printStackTrace();
		}
		return emp;
	}
}
