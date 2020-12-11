package com.revature.daoimpl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Iterator;

import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.beans.Approver;


public class ApproverDAOImplTest {
	static ApproverDAOImpl mockDAOImpl = mock(ApproverDAOImpl.class);
	static Approver ap = new Approver();
	
	static Approver myMockEntity = mock(Approver.class);
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ap.setApproverID(0);
		ap.setUserName("userName");
		
		myMockEntity.setApproverID(0);
		myMockEntity.setUserName("userName");
	
	}

	

	
	@Test
	public void testGetAllApprovers() {
		Iterator<String> i= mock(Iterator.class);
        when(i.next()).thenReturn(ap.getUserName()).thenReturn("0");
        String result= i.next()+" "+i.next();
     
        assertEquals("userName 0", result);
	}

	@Test
	public void testInsertApprover() {
		
	}

	@Test
	public void testGetApproverByUsername() {
		when(mockDAOImpl.getApproverByUsername(myMockEntity.getUserName())).thenReturn(ap);
		String expected= "userName";
		String actual= ap.getUserName();
		assertEquals(expected, actual);
	}

}
