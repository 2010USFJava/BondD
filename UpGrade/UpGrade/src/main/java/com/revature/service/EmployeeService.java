package com.revature.service;

import java.util.List;

import com.revature.beans.Employee;
import com.revature.dao.EmployeeDAO;
import com.revature.daoimpl.EmployeeDAOImpl;

public class EmployeeService {
	
	public EmployeeService() {
		super();
	}

	EmployeeDAO empDao = new EmployeeDAOImpl();
	
	public boolean loginVerify(String username, String password) {
		List<Employee> empList = empDao.getAllEmployees();
		boolean verify=false;
		for (Employee employee : empList) {
			if(employee.getUserName().equals(username)&&employee.getPassword().equals(password)) {
				verify=true;
			}
		}
		return verify;
	}
	
	public Employee loginGetEmp(String username, String password) {
		if(loginVerify(username,password)) {
			return empDao.getEmployeeByUsername(username);
		}
		return null;
	}
	
	public void insertNewEmp(Employee emp) {
		empDao.insertEmployee(emp);
	}
	
	public int loginGetEmpID() {
		if(loginVerify(null, null)==true) {
			return empDao.getEmployeeByUsername(null).getEmpID();
		}
		return 0;
	}
	
	public Employee getSessionEmp(int empID) {
		return empDao.getEmployeeById(empID);
	}
	
}
