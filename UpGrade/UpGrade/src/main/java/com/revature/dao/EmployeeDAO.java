package com.revature.dao;

import java.util.List;

import com.revature.beans.Employee;

public interface EmployeeDAO {
	public List<Employee> getAllEmployees();
	public void insertEmployee(Employee emp);
	public Employee getEmployeeByUsername(String username);
	public Employee getEmployeeById(int empID);
}
