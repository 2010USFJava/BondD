package com.revature.DAOInterface;

import java.sql.SQLException;

import com.revature.model.Account;

public interface AccountInterface {
	
	
	public void createNewAccount(Account a)throws SQLException;
	
	public void updateAccount(Account a) throws SQLException;
	
	public void deactivateAccount(Account a) throws SQLException;
	
	public void approveAccount (Account a) throws SQLException;
	
}
