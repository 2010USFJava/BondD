package com.revature.implementation;

import java.util.ArrayList;
import java.util.List;

import com.revature.model.EndUser;
import com.revature.view.ConsoleMenu;

public class EndUserImp  {
	protected static ArrayList<EndUser> endUserList = new ArrayList<>();
	
	

	private EndUserImp() {
		super();
	}
	
	public static void fillEndUserList(){
			CustomerImp customerImp = new CustomerImp();
			endUserList.addAll(customerImp.getCustomerList());
			endUserList.addAll(EmployeeImp.getEmployeeList());
			
			
	}

	public static List<EndUser> getEndUserList() {
		return endUserList;
	}

	public static void setEndUserList(ArrayList<EndUser> endUserList) {
		EndUserImp.endUserList = endUserList;
	}

	
 public static EndUser authenticateEndUser(String uName, String password) {
		 for(EndUser eu : endUserList) {
			
		if(eu.getUserName()!= null && eu.getUserName().equalsIgnoreCase(uName)
				 && eu.getPassword().equals(password)) {	
			
		 System.out.println("\t\t\tLog in Successful!");
			
			 return eu;
		 
		 }
	  }
		 System.out.println( "User Name and Password do not match. Please Try again.\n\n\n");
		 ConsoleMenu consoleMenu = new ConsoleMenu();
	consoleMenu.startMenu();
	return null;
	 
 }
 
 
 
 public static boolean verifyUserNameUnique(String uName) {
	
	for(EndUser eu: endUserList) {
		
			if ( eu.getUserName().trim().equalsIgnoreCase(uName)) {
				 System.out.println("User Name Already in use. Try again");
				 return true;
			 }
	}
	 
	return false;
 }
 
 public static EndUser lookUpEnduserbyUserName(String userName) {
	 String uN = userName;
	 for(EndUser eu: endUserList)
		 if (eu.getUserName().equalsIgnoreCase(uN)) {
			 return eu;
		 }
		 
	 
	return null;
 }
	
}
