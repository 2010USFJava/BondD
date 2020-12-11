package com.revature.driver;

import com.revature.beans.Employee;
import com.revature.dao.EmployeeDAO;
import com.revature.daoimpl.EmployeeDAOImpl;
import com.revature.service.EmployeeService;
import com.revature.utility.ConnFactory;

public class Main {
	public static ConnFactory cf = ConnFactory.getInstance();

	public static void main(String[] args) {
//		EmployeeDao a = new EmployeeDaoImpl();
//		a.getAllEmployees();
//		System.out.println(a.getAllEmployees().toString());
//		String url = "jdbc:postgresql://project1.cqb6pzj3paxs.us-east-2.rds.amazonaws.com:5432/projecttrms";
//		String username = "rootadmin";
//		String password="l0ckmeplease";
//
//		List<Employee> empList = new ArrayList<Employee>();
//		try {
//			
//			Connection conn = cf.getConnection();
//			String sql = "Select * FROM employees";
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ResultSet rs = ps.executeQuery();
//			while(rs.next()) {
//				empList.add(new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getDouble(6),rs.getInt(7),rs.getInt(8)));
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println(empList.toString());
		EmployeeDAO empDao= new EmployeeDAOImpl();
		System.out.println(empDao.getAllEmployees().toString());
		EmployeeService test = new EmployeeService();
//		System.out.println(test.loginVerify("david", "password1"));
//		System.out.println(test.loginGetEmp("david", "password1"));
		Employee emp = test.loginGetEmp("david", "password1");
		System.out.println(emp.toString());
	}

	
}
