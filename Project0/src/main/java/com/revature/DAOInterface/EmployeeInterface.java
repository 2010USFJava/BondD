package com.revature.DAOInterface;

import com.revature.model.Employee;

	public interface EmployeeInterface {
		
	public void createNewEmployee(Employee ex);
	
	public void updateEmployee(Employee ex);
	
	public void deactivateEmployee(Employee ex);
	
}
