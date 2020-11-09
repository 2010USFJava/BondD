package com.revature.Banking;

import java.util.ArrayList;
import java.util.List;

import com.revature.implementation.AccountImp;
import com.revature.implementation.EndUserImp;
import com.revature.model.Account;
import com.revature.model.Customer;
import com.revature.model.Employee;
import com.revature.model.EndUser;
import com.revature.utility.DataPersistenceUtility;
import com.revature.view.ConsoleMenu;

public class MainDriver {
  static { 
	  System.out.println("\t\t\tWelcome to Reveture bank.");

  AccountImp.setAccountList( (ArrayList<Account>) DataPersistenceUtility.readUtility(DataPersistenceUtility.getAccountfile()));
   EndUserImp.setEndUserList((ArrayList<EndUser>) DataPersistenceUtility.readUtility(DataPersistenceUtility.getEnduserfile()));
  }
  
  
	public static void main(String[] args) {
		
		// used to create the files the first run.	&& load sample data
		
		/*List <Integer> tempAcctList = new ArrayList<>();
		 tempAcctList.add(10001);
		EndUser cx = new Customer ("John", "Doe", "JoDoe", "password", true, "CUSTOMER", 1001, "123 Anywhere st, AnyCity, 44444", "555-555-1212", 
				tempAcctList);
	
		
		dUser ex = new Employee ("Standard", "Employee", "sEmployee", "password", true, "EMPLOYEE", 1, "teller") ;
			
		EndUser admin = new Employee("Admin", "Employee", "Admin", "password", true, "ADMIN", 0, "Field Technician");
		List <String> tempCxList = new ArrayList<>();
		tempCxList.add(cx.getUserName());
		Account acct = new Account(10001,50.00, true, true, tempCxList);
		
		
		System.out.println(AccountImp.getAccountList());	
		
		System.out.println(EndUserImp.getEndUserList());*/
	 
		ConsoleMenu.startMenu();
			
	}
	public static void close() {
		System.out.println("\t\t\t\tThank you, come agian!");
		
	}

}
