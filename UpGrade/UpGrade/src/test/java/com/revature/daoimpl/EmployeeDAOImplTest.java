package com.revature.daoimpl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Iterator;

import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.beans.Employee;

public class EmployeeDAOImplTest {
	static EmployeeDAOImpl mockDAOImpl = mock(EmployeeDAOImpl.class);
	static Employee ex = new Employee();
	
	static Employee myMockEntity = mock(Employee.class);
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ex.setFirstName("First");
		ex.setLastName("Last");
		ex.setEmpID(0);
		ex.setUserName("userName");
		myMockEntity.setFirstName("First");
		myMockEntity.setLastName("Last");
		myMockEntity.setEmpID(0);
		myMockEntity.setUserName("userName");
	
	}

	
	@Test
	public void testGetAllEmployees() {
		Iterator<String> i= mock(Iterator.class);
        when(i.next()).thenReturn(ex.getFirstName()).thenReturn(ex.getLastName());
        String result= i.next()+" "+i.next();
     
        assertEquals("First Last", result);
	}

	@Test
	public void testInsertEmployee() {
		ex.setEmpID(0);
		myMockEntity.setFirstName("First");
		myMockEntity.setLastName("Last");
		myMockEntity.setEmpID(0);
		
		
		
		int actual = ex.getEmpID();
		int expected = myMockEntity.getEmpID();
		assertEquals(expected, actual);
	}

	@Test
	public void testGetEmployeeByUsername() {
		when(mockDAOImpl.getEmployeeByUsername(myMockEntity.getUserName())).thenReturn(ex);
		String expected= "userName";
		String actual= ex.getUserName();
		assertEquals(expected, actual);
	}

}
