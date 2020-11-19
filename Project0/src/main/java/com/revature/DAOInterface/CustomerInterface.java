package com.revature.DAOInterface;

import com.revature.model.Customer;

public interface CustomerInterface {
	public void createNewCustomer(Customer cx);
	
	public void updateCustomer(Customer cx);
	
	public void deactivateCustomer(Customer cx);
	
}
