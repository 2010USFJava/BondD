package com.revature.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.revature.implementation.AccountImp;
import com.revature.utility.BankLogger;
import com.revature.utility.DataPersistenceUtility;

public class Account implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4943565665674681429L;
	private int accountID;
	private double balance;
	private boolean isDeactivated;
	private boolean isPending;
	private List<String> accountHolders = new ArrayList<>();
	
	public Account() {
		super();
		AccountImp.getAccountList().add(this);
		//DataPersistenceUtility.writeUtility(AccountImp.getAccountList(), DataPersistenceUtility.getAccountfile());
		BankLogger.LogIt("info","A new blank account was created");
	}
	
		
	public Account(int accountID, double balance, boolean isDeactivated, boolean isPending) {
		super();
		this.accountID = accountID;
		this.balance = balance;
		this.isDeactivated = isDeactivated;
		this.isPending = isPending;
		
	}


	public Account(int accountID, double balance, boolean isDeactivated, boolean isPending,
			List<String> accountHolders) {
		super();
		this.accountID = accountID;
		this.balance = balance;
		this.isDeactivated = isDeactivated;
		this.isPending = isPending;
		this.accountHolders = accountHolders;
		AccountImp.getAccountList().add(this);
		//DataPersistenceUtility.writeUtility(AccountImp.getAccountList(), DataPersistenceUtility.getAccountfile());
		BankLogger.LogIt("info","A new account was created [" + this.getAccountID() + "] for " +this.getAccountHolders()+".");
	}
	public List<String> getAccountHolders() {
		return accountHolders;
	}
	public void setAccountHolders(List<String> accountHolders) {
		this.accountHolders = accountHolders;
	}
	
	public boolean isDeactivated() {
		return isDeactivated;
	}
	
	
	public int getAccountID() {
		return accountID;
	}
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}


	public boolean isPending() {
		return isPending;
	}


	public void setPending(boolean isPending) {
		this.isPending = isPending;
	}


	


	public void setDeactivated(boolean isDeactivated) {
		this.isDeactivated = isDeactivated;
	}


	@Override
	public String toString() {
		return "Account [accountID=" + accountID + ", balance=" + balance + ", Deactivated= " + isDeactivated +", isPending= "+ isPending
				+ ", accountHolder(s)=" + accountHolders + "]";
	}
	
	
	
	
}
