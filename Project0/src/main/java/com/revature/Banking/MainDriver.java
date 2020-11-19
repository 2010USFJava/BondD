package com.revature.Banking;

import java.util.ArrayList;
import java.util.List;

import com.revature.implementation.AccountImp;
import com.revature.implementation.CustomerImp;
import com.revature.implementation.EmployeeImp;
import com.revature.implementation.EndUserImp;
import com.revature.model.Account;
import com.revature.model.Customer;
import com.revature.model.Employee;
import com.revature.model.EndUser;
import com.revature.utility.DataPersistenceUtility;
import com.revature.view.ConsoleMenu;

public class MainDriver {
  static { 
	  CustomerImp.fillCustomerList();
	  EmployeeImp.fillEmployeeList();
	  EndUserImp.fillEndUserList();
	  AccountImp.fillAccountList();
	  System.out.println("\n\n\t\t\t *******************************");
	  System.out.println("\t\t\t *  Welcome to Reveture bank!  *");
	  System.out.println("\t\t\t *******************************");
   
  }
  
  
	public static void main(String[] args) {
		
		ConsoleMenu console = new ConsoleMenu();
		
		//System.out.println(AccountImp.getAccountList());	
		
		//System.out.println(EndUserImp.getEndUserList());
	 
		console.startMenu();
			
	}
	
		
	}


