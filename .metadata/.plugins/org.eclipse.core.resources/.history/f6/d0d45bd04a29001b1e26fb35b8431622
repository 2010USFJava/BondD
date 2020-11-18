package com.revature.view;

import java.util.ArrayList;
import java.util.List;

import com.revature.implementation.AccountImp;
import com.revature.implementation.CustomerImp;
import com.revature.implementation.EndUserImp;
import com.revature.model.Account;
import com.revature.model.Customer;
import com.revature.model.Employee;
import com.revature.model.EndUser;

//format the display with information
public class Display {
private final static String TABS = "\t\t\t";
	
	//display updated info
	//display accounts list
	//display employee list
	//display customer list
	//display customer registration confirmation
	//display employee register confirmation
	
	
	
	private static void header(String header) {
	 System.out.println(TABS+ "****************************************************************");
	 System.out.println(TABS+TABS+ header );
	 System.out.println(TABS+"****************************************************************");
	}
	private static void divider() {
		 System.out.println(TABS+"****************************************************************");
		 System.out.println("\n"+TABS+"****************************************************************");
		}
	private static void screenScroll() {
		for(int i = 0 ; i< 20 ; i++) {
			System.out.println("");
		}
	}
	public static void customerDetails(Customer customer) {
	 Customer cx = customer;
	
	 header("Customer Details");
	 System.out.println("");
	 System.out.println("");
	 System.out.println(TABS+ TABS+" Hello "+ cx.getfName());
	 System.out.println("");
	 System.out.println("");
	 System.out.println(TABS+"  Name: " + cx.getfName()+ " "+ cx.getlName()+ "\t Phone Number: " + cx.getPhoneNumber());
	 System.out.println("");
	 System.out.println("");
	 System.out.println(TABS+"  User Name: " +cx.getUserName());
	 System.out.println("");
	 System.out.println("");
	 System.out.println(TABS+"  Address: " + cx.getAddress());
	 System.out.println("");
	 
	 System.out.println("");
	 System.out.println("");
	 
	 divider();
	 ConsoleMenu.updateCustomerDetails(cx);
	}
	
	
 public static void accountDetails(Account account, EndUser currentUser) {
		Account acct = account;
		EndUser eu= currentUser;
		 header("Account Details");
		 System.out.println("");
		 System.out.println("");
		 System.out.println(TABS+"Account Number "+ acct.getAccountID());
		 System.out.println("");
		 System.out.println("");
		 System.out.println(TABS+"Balance " + acct.getBalance());
		 System.out.println("");
		 System.out.println("");
		 System.out.println(TABS+" Account Holders " + acct.getAccountHolders());
		 System.out.println("");
		 System.out.println("");
		 System.out.println("");
		  if (acct.isPending()) {
			 System.out.println("\t\t\tACCOUNT IS PENDING!");
		 }else if (acct.isDeactivated()) {
			 System.out.println("\t\t\tACCOUNT IS NOT ACTIVE.");
		 } 
		 divider();
		if (eu instanceof Customer) {
	ConsoleMenu.updateAccountTransactions(acct,eu);
		} else if (eu instanceof Employee) {
			ConsoleMenu.employeeAccountUpdate(acct,eu);
		}
	}
	
	public static void customerDetailsUpdate(Customer customer) {
		Customer cx = customer;
		 header("Update Customer");
		 System.out.println("");
		 System.out.println("");
		 System.out.println(TABS+"What would you like to change?");
		 System.out.println("");
		 System.out.println("");
		 System.out.println(TABS+"User Name: " +cx.getUserName());
		 System.out.println(TABS+"[1] Password");
		 System.out.println("");
		 System.out.println(TABS+"[2]Address: " + cx.getAddress());
		 System.out.println(TABS+"[3]Phone Number: " + cx.getPhoneNumber());
		 System.out.println("");
		 
		 System.out.println("");
		 System.out.println("");
		  divider();
		 		 		 
	}
	
	public static void viewAllAccounts(Employee currentEU) {
		header("All Accounts");
		AccountImp.getAccountList().forEach((acct) -> {
			System.out.println(acct.toString()+ "\n");
		});
		ConsoleMenu.accountLookUpMenu(currentEU);
		divider();
		
	}
	
	public static void viewAllCustomers(Employee currentEmp) {
		header("All Customers");
		CustomerImp.customerLookUpList().forEach((cx) -> {
			System.out.println( " User Name: "+ cx.getUserName()+ ", Name: " + cx.getfName() +" " + cx.getlName()+",  "+ cx.toString()+ "\n");
					
		});
		ConsoleMenu.cxLookUpMenu(currentEmp);
		
	}
	public static void viewAllEmployees(Employee admin) {
		header("All Employees");
		List<Employee> tempList = new ArrayList<Employee>();
		EndUserImp.getEndUserList().forEach((eu) -> {
			if (eu instanceof Employee) {
				System.out.println("User Name; " +eu.getUserName()+ ", Name: " + eu.getfName() +" " + eu.getlName()+", " +eu.toString() + "\n" );
			}
		});
		ConsoleMenu.employeeLookUpMenu(admin);
	}
	public static void employeeDetails(Employee employee, Employee admin) {
		Employee emp = employee;
		
		 header("Employee Details");
		 
		 System.out.println("");
		 System.out.println("");
		 System.out.println(TABS+"  Name: " + emp.getfName()+ " "+ emp.getlName()+ "\t Position: " + emp.getPosition());
		 System.out.println("");
		 System.out.println("");
		 System.out.println(TABS+"  User Name: " +emp.getUserName());
		 System.out.println("");
		 System.out.println("");
		 System.out.println(TABS+"  Employee ID: " + emp.getEmployeeID()+ "\t  Active =" + emp.isActive());
		 System.out.println("");
		 System.out.println("");
		 System.out.println("");
		 
		 divider();
		 
		 ConsoleMenu.updateEmployeeDetails(emp, admin);
		}
	public static void employeeUpdate(Employee emp) {
		
		
		 header("Employee Update");
		 
		 System.out.println("");
		 System.out.println("");
		 System.out.println(TABS+"[1]  Name: " + emp.getfName()+ " "+ emp.getlName()+ "\t [2]Position: " + emp.getPosition());
		 System.out.println("");
		 System.out.println("");
		 System.out.println(TABS+" [3] User Name: " +emp.getUserName() + "\t [4]Reset password:");
		 System.out.println("");
		 System.out.println("");
		 System.out.println(TABS+" [5] Employee ID: " + emp.getEmployeeID() + "\t [6] Active =" + emp.isActive());
		 System.out.println("");
		 System.out.println("");
		 System.out.println(TABS +"[7] Status " + emp.getStatus());
		  divider();
		
	}
		
	}
	
	


