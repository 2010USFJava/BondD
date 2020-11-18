package com.revature.implementation;

import com.revature.model.Employee;
import com.revature.model.EndUser;

public class EmployeeImp {

	public static Employee lookUpBYID(int employeeID) {
		for (EndUser eu : EndUserImp.endUserList)
			if (eu instanceof Employee) {
				if (((Employee) eu).getEmployeeID() == employeeID){
					return (Employee) eu;
				}
			}
		return null;
	}

}
