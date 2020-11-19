package com.revature.implementation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.revature.DAOInterface.AccountInterface;
import com.revature.model.Account;
import com.revature.model.Customer;
import com.revature.utility.BankLogger;
import com.revature.utility.DataPersistenceUtility;

public class AccountImp implements AccountInterface{	public AccountImp() {
		
	}
	
	private static ArrayList<Account> accountList = new ArrayList<>();
    
	
	
	//fill account list from DB
	
	public static List<Account> fillAccountList(){
		accountList.clear();
		
		
		String sql= "select account_id, balance, is_deactivated, is_pending from project0.account";
		
		try {
			int id;
			double bal;
			boolean pending;
			boolean notActive;
			//list to hold account holders 
			
			ResultSet rs = DataPersistenceUtility.getResultSet(sql);
			while (rs.next()) {
			id= rs.getInt("account_id");
			bal= rs.getDouble("balance");
			pending = rs.getBoolean("is_pending");
			notActive= rs.getBoolean("is_deactivated");
					
						//select where statement
			//create new account 
			Account a = new Account (id,bal,pending,notActive);
			//add new account to the list 
			getAccountList().add(a);
			
			   }
			
			
			return accountList;
			
		} catch (SQLException e) {
			System.out.println("Check account List SQL"  +e.getSQLState() + e.getMessage());
			e.printStackTrace();
		}
		return accountList;
		
	}	
		
		
		
	
	//get Account list from file
	public static  List<Account> getAccountList(){

		return accountList;
	}
	
	


	// update Accounts
	public  void setAccountList(List<Account> acctList) {
		accountList = (ArrayList<Account>) acctList;
	}

	public static Account accountLookUpByNum(int accountNum) {
	  for(Account account : accountList)
		  if (account.getAccountID() == accountNum) {
			  return account;
		  }		
		return null;
	}


	public  void deposit(double amt, Account acct) {
		Account account = acct ;
		double amount = amt;
		double newBalance = account.getBalance() + amount;
		account.setBalance(newBalance);
		updateAccount(account);
		System.out.println("Your new balance is " + account.getBalance());
		BankLogger.LogIt("info", "Deposit in the amount of " +amt+ " to " +acct.getAccountID()+ "was successful."); 
	}


	public void withdrawal(double amt, Account acct) {
		Account account = acct ;
		double amount = amt;
		
		double newBalance = account.getBalance() - amount;
		account.setBalance(newBalance);
		updateAccount(account);
		System.out.println("Your new balance is " + account.getBalance());
		BankLogger.LogIt("info","Withdrawal of " +amt+ " from " +acct.getAccountID()+" was successful.");
	}

	
	
	public  void approvePendingAccount(Account acct) {
		Account account = acct;
		account.setPending(false);
		account.setDeactivated(false);
		
		
		System.out.println("Account " +account.getAccountID()+ " is active and no longer pending!");
		BankLogger.LogIt("info", "Account " +account.getAccountID()+ " has been approved." );
		
	}


	@Override
	public void createNewAccount(Account a) {
		String sql = "Insert into project0.account (balance, is_deactivated, is_pending) values (?,?,?)";
		
				try {
					PreparedStatement stmnt = DataPersistenceUtility.makePrStmnt(sql);
					stmnt.setDouble(1, a.getBalance());
					stmnt.setBoolean(2, a.isDeactivated());
					stmnt.setBoolean(3, a.isPending());
					
					stmnt.executeUpdate();
					fillAccountList();
					
					
					
				}catch(SQLException sqe){
			          System.out.println("Check Account Insert SQL " + sqe.getSQLState() + sqe.getMessage());
			        } catch (Exception e) {
			            System.out.println("Error:" +e.getMessage());
			         }
		
	}


	@Override
	public void updateAccount(Account a) {
		String sql = "UPDATE project0.account SET  balance = ?, is_deactivated = ?," +
	            " is_pending = ?  WHERE account_id = ?";
	       
	        try {
	        	PreparedStatement stmnt = DataPersistenceUtility.makePrStmnt(sql);
	            stmnt.setDouble(1, a.getBalance());
	            stmnt.setBoolean(2, a.isDeactivated());
	            stmnt.setBoolean(3, a.isPending());
	            stmnt.setInt(4, a.getAccountID());
	            stmnt.executeUpdate();
	            
	            fillAccountList();
	            
	         } catch(SQLException sqe){
	          System.out.println("Check Account Update SQL " + sqe.getSQLState() + sqe.getMessage());
	        } catch (Exception e) {
	            System.out.println("Error:" +e.getMessage());
	         }
	    }
		
	


	@Override
	public void deactivateAccount(Account a) {
		
		if (a.getBalance()==0) {
		 String sql = "DELETE from project0.account WHERE account_id = ? ";
	     
	     try {
	        	PreparedStatement stmnt = DataPersistenceUtility.makePrStmnt(sql);
	             stmnt.setInt(1,a.getAccountID());
	             stmnt.executeUpdate();
	             
	             fillAccountList();
	        } catch(SQLException sqe){
	          System.out.println("Check Customer DELETE SQL " + sqe.getSQLState() + sqe.getMessage());
	        } catch (Exception e) {
	            System.out.println("Error:" +e.getMessage());
	         }
		} else {
			System.out.println("Account Balance is " +a.getBalance()+ ". Account must have a 0 balance to be deleted. ");
		}
	}
	
	
	public void insertAccountLookup (Customer cx, Account a) {
		String sql= "Insert into project0.account_lookup(account_id, customer_id) values (?,?)";
		List<Integer> templist = new ArrayList<Integer>();
		for (Account acct : accountList) {
			templist.add(acct.getAccountID());
			
		}
		Collections.sort(templist);
		 
		 a.setAccountID(templist.get(templist.size() -1));
	
		try {
			PreparedStatement stmnt =  DataPersistenceUtility.makePrStmnt(sql);
				stmnt.setInt(1, a.getAccountID());
				stmnt.setInt(2, cx.getCustomerID());
				stmnt.executeUpdate();
				BankLogger.LogIt("info","A new account was created for  "+cx.getfName()+" "+cx.getlName()+ "Account Id: "+ a.getAccountID() +".");
		} catch (SQLException e) {
			System.out.println("Check accountLookup insert SQL " + e.getSQLState() + e.getMessage());
		}
	}

	


	public static List<Integer> lookupAcctbyCxID(Customer cx){
		List<Integer> lookUpList = new ArrayList<Integer>();
	String 	sql= " Select account_id from project0.account_lookup Where customer_id = ?";
		
		try {
			int acctID;
			PreparedStatement stmnt = DataPersistenceUtility.makePrStmnt(sql);
			stmnt.setInt(1,cx.getCustomerID());
			ResultSet rs = stmnt.executeQuery();
			while (rs.next()) {
			lookUpList.add(rs.getInt("account_id"));
			}
		} catch (SQLException e) {
			System.out.println("Check lookup account SQL " + e.getSQLState() + " " + e.getMessage());
		}
		return lookUpList;
	}

}


