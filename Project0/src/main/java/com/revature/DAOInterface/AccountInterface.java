package com.revature.DAOInterface;

import com.revature.model.Account;
import com.revature.model.Customer;

public interface AccountInterface {
	
	
	public void createNewAccount(Account a);
	
	public void updateAccount(Account a);
	
	public void deactivateAccount(Account a);
	

	
}
