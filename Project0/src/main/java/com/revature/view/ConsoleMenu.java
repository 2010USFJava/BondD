package com.revature.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.Banking.MainDriver;
import com.revature.implementation.AccountImp;
import com.revature.implementation.CustomerImp;
import com.revature.implementation.EmployeeImp;
import com.revature.implementation.EndUserImp;
import com.revature.model.Account;
import com.revature.model.Customer;
import com.revature.model.Employee;
import com.revature.model.EndUser;
import com.revature.utility.DataPersistenceUtility;

//record input 
public class ConsoleMenu {
 
 private static Scanner input = new Scanner(System.in);
 // Welcome & login menu
 public static void startMenu(){
	
	 try {
		System.out.println("\t\t\t What would you like to do?");
		 int decision;
		 System.out.println("\t[1] Log in?");
		 System.out.println("\t[2] Register?");
		 System.out.println("\t[3] Quit?");
		 decision = Integer.parseInt(input.nextLine());
		 if (decision== 1) {
			 login();
		 }else if (decision==2) {
			 customerRegister();
		 }else  if (decision==3){
			 MainDriver.close();
		 }else {
			 System.out.println("\t Please enter 1 for login or 2 to register.");
			 startMenu();
		 }
	} catch (NumberFormatException e) {
		System.out.println("Please enter a number.");
		startMenu();
		
	}
			 
	 
 }
	 
 public static void login(){
   try {
	String userName;
	String password;
	System.out.println("\tPlease enter your User Name");
	userName= input.nextLine();
	System.out.println("\tPlease enter your password.");
	password= input.nextLine();
	
	EndUser currentEndUser = EndUserImp.authenticateEndUser(userName, password);
	System.out.println(currentEndUser);
		if (currentEndUser!= null) {
			mainMenu(currentEndUser);
			
			 } else {
				 startMenu();
			 }
			  
				 
		
} catch (NullPointerException e) {
	System.out.println("\t\t\tPlease enter a value for each field.");
	
		startMenu();
}
}

   public static void mainMenu(EndUser currentEU) {
	   String status = currentEU.getStatus();
			 switch (status){
			 case "CUSTOMER":
				 Display.customerDetails((Customer) currentEU);
				 
				 break;
			 case "EMPLOYEE":
				  employeeMenu((Employee) currentEU);
				
				 break;
			 case "ADMIN":
				 adminMenu((Employee) currentEU);
				 
				 break;
			 default:
					 System.out.println("\t\t\tError: an unexpected error has occured Please log in again.");
					 login();
   }
	 
 }

 public static void customerRegister(){
	 String uName;
	 String password;
	List<Integer> tempAcctList = new ArrayList<>();
	int cxID;
	String fName ;
	String lName;
	String phNum;
	String stAdd;
	String cityAdd;
	String zpAdd;
	try {
		
		 tempAcctList.add(0);
		 cxID = CustomerImp.assignID();
		 System.out.println("\t\t\tPlease enter first name");
		 fName = input.nextLine();
		 System.out.println("\t\t\tPlease enter last name.");
		 lName = input.nextLine();
		 System.out.println("\t\t\tPlease enter a user name ");
		  uName=input.nextLine();
		 password = confirmPassword();
		 System.out.println("\t\t\tPlease enter a phone number");
		 phNum = input.nextLine();
		 System.out.println("\t\t\tPlease enter a street Address");
		 stAdd = input.nextLine();
		 System.out.println("\t\t\tPlease enter a city");
		 cityAdd = input.nextLine();
		 System.out.println("\t\t\tPlease enter a Zipcode");
		 zpAdd = input.nextLine();
		 String add = stAdd + ","+ cityAdd+ ","+ zpAdd;  
		 Customer a = new Customer(fName, lName,  uName, password, true, "CUSTOMER",cxID, add, phNum,tempAcctList);
		 Display.customerDetails(a);
		 System.out.println(a);
	  startMenu();
	} catch (NullPointerException e) {
	 System.out.println("\t\t\tPlease enter a value for each field.");
		startMenu();
	}
 }
	 
 
// customer menus
 
 
 //look up account verifying account holder and account number
 public static void viewAccount(String userName){

	 Customer currentCx = CustomerImp.customerLookUp(userName);
	 try {
		 if (CustomerImp.customerLookUp(userName).getAccountNumList().isEmpty() || currentCx.getAccountNumList().indexOf(0)==0) {
			 System.out.println("\t\tYou don't seem to have an account with us, \n Would you like to request one?");
			 System.out.println("\t[1] Yes \t[2] No");
			 String yesNo = input.nextLine();
			 if (yesNo.trim().contains("1")){
				 accountRequest(currentCx);

			 } else if (yesNo.trim().contains("2")){
				 MainDriver.close();


			 }
		 }	else {
			
			 
				 System.out.println("\t\t\tPlease enter your account number");
				 int accountNum = Integer.parseInt(input.nextLine());
				 if (AccountImp.accountLookUp(accountNum, userName)) {

					 Display.accountDetails(AccountImp.accountLookUpByNum(accountNum), currentCx);

			 }
				 else {
					 mainMenu(currentCx);
				 }
			
		 }
	 }catch (NumberFormatException e) {
		 System.out.println("\t\t\tPlease enter a number.");
		 viewAccount(userName);

	 } catch (NullPointerException e) {
		 System.out.println("\t\t\tPlease enter a VALID account number.");
		 viewAccount(userName);
		 e.printStackTrace();
	 }

 }






 
public static void updateCustomerDetails(Customer cx) {
	System.out.println("\t\t\t[1] Update Customer Details? \t[2] View account?\t [3] Apply for new account?");
	String decision = input.nextLine();
	 if (decision.contains("1")){
		 Display.customerDetailsUpdate(cx);
		 decision = input.nextLine();
		  switch (decision) {
		  case "1"://update password
			  cx.setPassword(confirmPassword());
			  System.out.println("Password has been updated");
			  DataPersistenceUtility.writeUtility(EndUserImp.getEndUserList(), DataPersistenceUtility.getEnduserfile());
			  updateCustomerDetails(cx);
		  break;
		  case "2"://update address
			  System.out.println("What is your new street address?");
			  String stAdd = input.nextLine();
			  System.out.println("New City?");
			  String city = input.nextLine();
			  System.out.println("New Zipcode?");
			  String zp = input.nextLine();
			  cx.setAddress(stAdd + ", "+ city+", "+ zp);
			  DataPersistenceUtility.writeUtility(EndUserImp.getEndUserList(), DataPersistenceUtility.getEnduserfile());
			  System.out.println("Your address has been updated!");
			  updateCustomerDetails(cx);
		  break;
		  case "3"://update phone number
			  System.out.println(" What is your New phone number?");
			  String phNum= input.nextLine();
			  cx.setPhoneNumber(phNum);
			  DataPersistenceUtility.writeUtility(EndUserImp.getEndUserList(), DataPersistenceUtility.getEnduserfile());
			  System.out.println("Your phone number has been updated");
			  updateCustomerDetails(cx);
		  break;
		  default:
			  System.out.println("\t\t\tPlease enter 1 to update password, 2 to update address or 3 to update phone number.");
			  updateCustomerDetails(cx);
		  }
	 }else if (decision.contains("2")){
		 viewAccount(cx.getUserName());
	 }
	 else if (decision.contains("3")) {
		 accountRequest(cx);
	 } else{ mainMenu(cx);
	 }
	
	
	
	
	
}

public static void updateAccountTransactions(Account account, EndUser currentUser) {
	Account acct = account;
	EndUser eu = currentUser;
	System.out.println("\t\t\t Please choose an option.");
	
	try {
		System.out.println("\t[1] Deposit funds?");	//deposit
		System.out.println("\t[2] Withdraw Funds?");//withdrawal
		System.out.println("\t[3] Transfer funds to another account?");//transfer
		System.out.println("\t[4]  Go back to main menu?");// cancel
		int decision = Integer.parseInt(input.nextLine());
		double amt;
		 switch (decision ) {
		 case (1):
			 System.out.println("\t Enter amount to deposit.");
		 		amt = Double.parseDouble(input.nextLine());
		 		AccountImp.deposit(amt, account);
		 		updateAccountTransactions(acct, eu);
			 break;
		 case(2):
			 System.out.println("\t Enter amount to withdraw.");
		 		amt = Double.parseDouble(input.nextLine());
		 		AccountImp.withdrawal(amt, account);
		 		updateAccountTransactions(acct, eu);
			 break;
		 case (3):
			 System.out.println("\t Enter amount to transfer.");
		 		amt = Double.parseDouble(input.nextLine());
		 	 System.out.println("\t What is the Account Number you want to transfer TO ");
		 	  int to = Integer.parseInt(input.nextLine());
		 	  AccountImp.transferFunds(amt, acct, to);
		 	 updateAccountTransactions(acct, eu);
			 break;
		 
			default: 
				 mainMenu(eu);
		 }
		
		
	} catch (NullPointerException e) {
		System.out.println("Please input a value.");
		 updateAccountTransactions(acct, eu);
	}catch (NumberFormatException e) {
		System.out.println("Please enter 1 to deposit funds, 2 to withdraw funds, 3 to transfer funds to another account or 4 to cancel.");
		 updateAccountTransactions(acct, eu);
	}catch (Exception e) {
		e.printStackTrace();
	}

	
	
}

public static void accountRequest(Customer cx) {
	System.out.println("What is the initial deposit?");
	double deposit = Double.parseDouble(input.nextLine());
	List<String> acctHolders = new ArrayList<>();
	acctHolders.add(cx.getUserName());
	System.out.println("Is this a joint account?");
	String yesNo= input.nextLine();
	if (yesNo.equalsIgnoreCase("yes")) {
		System.out.println("Please input the user name of the second account holder.");
		String secondAccountHolder = input.nextLine();
		Customer acctHolder2= CustomerImp.customerLookUp(secondAccountHolder);
		 if (acctHolder2 != null) {
			acctHolders.add( acctHolder2.getUserName());
			 
		 } else {
			 System.out.println("Account holder not found, please verify userName and try again.");
			 mainMenu(cx);
		 }
	} 
	int acctId= AccountImp.assignAccountNumber();
	
	Account a = new Account (acctId,deposit,false, true, acctHolders);
	cx.getAccountNumList().add(acctId);
	System.out.println( "\t Your request has been recieved.");
	
	System.out.println(a.toString());
	
	mainMenu(cx);
}
//employee menus


 public static void employeeMenu(Employee emp) {
	 System.out.println("Please choose an option.");
		System.out.println("[1] Account Lookup");
		System.out.println("[2] Customer Lookup");
		int decision = Integer.parseInt(input.nextLine());
		switch (decision) {
		case(1)://lookup account
		Display.viewAllAccounts(emp);
		break;
		case(2): //lookup customer
		Display.viewAllCustomers(emp);
		break;
		default: 
			mainMenu(emp);
		}
	 customerRegister();
	 
	 
 }
 
//admin menus
 
	public static void adminMenu(Employee admin) {
		System.out.println("Please choose an option.");
		System.out.println("[1] Account Lookup");
		System.out.println("[2] Customer Lookup");
		System.out.println("[3] Employee Lookup ");
		System.out.println("[4] Additional Admin Menus ");
		int decision = Integer.parseInt(input.nextLine());
		switch (decision) {
		case(1)://lookup account
		Display.viewAllAccounts(admin);
		break;
		case(2): //lookup customer
		Display.viewAllCustomers(admin);
		break;
		case(3):// lookup employees
		Display.viewAllEmployees(admin);
		break;
		case(4):
			
			break;
		default:
		mainMenu(admin);	
		
		}
		
	}
	
   
   
  
   
   private static String confirmPassword() {
	   try {
		String p1;
		String p2;
		   do {System.out.println("\t\t\tPlease enter a password");
			  p1 =input.nextLine();
			 System.out.println("\t\t\tPlease confirm password");
			 p2 =input.nextLine();
			  } while (!p1.equals(p2) || p1.isBlank());
		   return p2;
	} catch (NullPointerException e) {
		System.out.println("Fields cannot be blank, please enter a value.");
		confirmPassword();
	}
	return " ";
		  
   }

public static void accountLookUpMenu(Employee currentEmp) {
	try {
		int acctNum;
		Employee cEmp = currentEmp;
		System.out.println("\t\tPlease enter the account number to view details:");
		acctNum= Integer.parseInt(input.nextLine());
		Account account = AccountImp.accountLookUpByNum(acctNum);
		
		Display.accountDetails(account, cEmp);
	} catch (NumberFormatException e) {
		System.out.println("Please enter an account NUMBER to proceed");
		
		accountLookUpMenu(currentEmp);
	} catch (NullPointerException e) {
		System.out.println("Please verify that the Account number is correct and try again.");
		accountLookUpMenu(currentEmp);
	}
}

public static void employeeAccountUpdate(Account acct, EndUser eu) {
	try {
		System.out.println("\t[1] Deposit funds?");	//deposit
		System.out.println("\t[2] Withdraw Funds?");//withdrawal
		System.out.println("\t[3] Transfer funds to another account?");//transfer
		System.out.println("\t[4] Add another account holder?"); //add account holder to joint acct
	    System.out.println("\t[5] Approve a pending account?"); //approve pending accounts
		System.out.println("\t[6]  Go back to main menu?");// cancel
		int decision = Integer.parseInt(input.nextLine());
		double amt;
		 switch (decision ) {
		 case (1):
			 System.out.println("\t Enter amount to deposit.");
		 		amt = Double.parseDouble(input.nextLine());
		 		AccountImp.deposit(amt, acct);
		 		employeeAccountUpdate(acct, eu);
		 		mainMenu(eu);
			 break;
		 case(2):
			 System.out.println("\t Enter amount to withdraw.");
		 		amt = Double.parseDouble(input.nextLine());
		 		AccountImp.withdrawal(amt, acct);
		 		employeeAccountUpdate(acct, eu);
		 		
			 break;
		 case (3):
			 System.out.println("\t Enter amount to transfer.");
		 		amt = Double.parseDouble(input.nextLine());
		 	 System.out.println("\t What is the Account Number you want to transfer TO ");
		 	  int to = Integer.parseInt(input.nextLine());
		 	  AccountImp.transferFunds(amt, acct, to);
		 	 employeeAccountUpdate(acct, eu);
		 	 
			 break;
		 case(4):
			 System.out.println("Enter the customer User name.");
		 String cUserName = input.nextLine();
		     Customer cx =(Customer) EndUserImp.lookUpEnduserbyUserName(cUserName);
			 AccountImp.addAccountHolder(acct,cx);
			 employeeAccountUpdate(acct, eu);
			 break;
		 case(5):
			 AccountImp.approvePendingAccount(acct);
		 employeeAccountUpdate(acct, eu);
			 break;
		 
			default: 
				 mainMenu(eu);
		 }
		
		
	} catch (NullPointerException e) {
		System.out.println("Please input a value.");
		employeeAccountUpdate(acct, eu);
	}catch (NumberFormatException e) {
		System.out.println("Please enter 1 to deposit funds, 2 to withdraw funds, 3 to transfer funds to another account or 4 to cancel.");
		employeeAccountUpdate(acct, eu);
	}catch (Exception e) {
		System.out.println("Ut Oh , you broke it. Start over");
		startMenu();
		e.printStackTrace();
	}
	
}

public static void cxLookUpMenu(Employee currentEmp) {
	try {
		String cxUserName;
		
		System.out.println("\t\tPlease enter the Customer User Name to view details:");
		cxUserName = input.nextLine();
		Customer cx = CustomerImp.customerLookUp(cxUserName);
		 Display.customerDetails(cx);
		
	} catch (NullPointerException e) {
		System.out.println("Please verify that the customer user name is correct and try again.");
		
		cxLookUpMenu(currentEmp);
	}
	
}

public static void employeeLookUpMenu(Employee admin) {
	
	try {
		int employeeID;
		Employee administrator = admin;
		System.out.println("\t\tPlease enter the Employee ID to view details:");
		employeeID = Integer.parseInt(input.nextLine());
		Employee employee = EmployeeImp.lookUpBYID(employeeID);
		 Display.employeeDetails(employee, administrator);
		
	} catch (NullPointerException e) {
		System.out.println("Please verify that the customer user name is correct and try again.");
		employeeLookUpMenu(admin);
	}
	
}

public static void updateEmployeeDetails(Employee emp, Employee admin) {
	System.out.println("\t[1] Update Employee?");
	 System.out.println("\t[2] Back to main menu?");
	 System.out.println("\t[3] Quit?");
	int choice = Integer.parseInt(input.nextLine());
 
	if (choice ==1) {
		Display.employeeUpdate(emp);
		try {
			int decision = Integer.parseInt(input.nextLine());
			switch (decision) {
			case (1): //name
				System.out.println("\t Enter the  Employee new first name.");
				String fName = input.nextLine();
				emp.setfName(fName);

				System.out.println("\t Enter the Employee new Last name.");
				String lName = input.nextLine();
				emp.setlName(lName);
				DataPersistenceUtility.writeUtility(EndUserImp.getEndUserList(),
						DataPersistenceUtility.getEnduserfile());
				System.out.println("\t Name has been updated to " + emp.getfName() + " " + emp.getlName());
				updateEmployeeDetails(emp,admin);
				break;
			case (2): //position
				System.out.println("\t Enter the  Employee new position.");
				String position = input.nextLine();
				emp.setPosition(position);
				DataPersistenceUtility.writeUtility(EndUserImp.getEndUserList(),
						DataPersistenceUtility.getEnduserfile());
				System.out.println("\t Position has been updated to " + emp.getPosition());
				updateEmployeeDetails(emp,admin);
				break;
			case (3)://username
				System.out.println("\t Enter the Employee new username.");
				String userName = input.nextLine();
				emp.setUserName(userName);
				DataPersistenceUtility.writeUtility(EndUserImp.getEndUserList(),
						DataPersistenceUtility.getEnduserfile());
				System.out.println("\t User name has been updated to " + emp.getUserName());
				updateEmployeeDetails(emp,admin);
				break;
			case (4): //password
				System.out.println("\t Enter the Employee password.");
				String password = input.nextLine();
				emp.setPassword(password);
				DataPersistenceUtility.writeUtility(EndUserImp.getEndUserList(),
						DataPersistenceUtility.getEnduserfile());
				System.out.println("\t Password has been reset. ");
				updateEmployeeDetails(emp,admin);
				break;
			case (5): //employee Id
				System.out.println("\t Enter the Employee new ID.");
				int empID = Integer.parseInt(input.nextLine());
				emp.setEmployeeID(empID);
				DataPersistenceUtility.writeUtility(EndUserImp.getEndUserList(),
						DataPersistenceUtility.getEnduserfile());
				System.out.println("\t Employee ID has been updated to " + emp.getEmployeeID());
				updateEmployeeDetails(emp,admin);
				break;
			case (6): //active
				System.out.println("\t Are you sure you want to deactivate Employee? [Yes] or [No]");
				String yesNo = input.nextLine();
				if (yesNo.equalsIgnoreCase("yes")) {
					emp.setActive(false);
					DataPersistenceUtility.writeUtility(EndUserImp.getEndUserList(),
							DataPersistenceUtility.getEnduserfile());
					System.out.println("\t Employee is active is  " + emp.isActive());
				}
				updateEmployeeDetails(emp,admin);
				break;
			case (7): //status
				System.out.println("\t Choose a Status");
				System.out.println("\t [1] Employee \t  [2] Admin");
				int status = Integer.parseInt(input.nextLine());
				if (status == 2) {
					emp.setStatus("ADMIN");
					DataPersistenceUtility.writeUtility(EndUserImp.getEndUserList(),
							DataPersistenceUtility.getEnduserfile());
				} else {
					emp.setStatus("EMPLOYEE");
					DataPersistenceUtility.writeUtility(EndUserImp.getEndUserList(),
							DataPersistenceUtility.getEnduserfile());
				}
				System.out.println("\t has been updated to " + emp.getStatus());
				updateEmployeeDetails(emp,admin);
				break;
			default:
				mainMenu(admin);
			}
		} catch (NumberFormatException e) {
			System.out.println("\t\tPlease enter a NUMBER");

			mainMenu(admin);
			e.printStackTrace();
		} 
	} else if (choice ==3) {
		MainDriver.close();
	}else {
		mainMenu(admin);
	}
}
   
   
}
