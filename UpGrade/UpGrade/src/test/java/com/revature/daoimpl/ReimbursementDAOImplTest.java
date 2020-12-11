package com.revature.daoimpl;

import static org.junit.Assert.assertEquals;

import static org.mockito.Mockito.*;



import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.revature.beans.Reimbursement;

public class ReimbursementDAOImplTest {
	static ReimbursementDAOImpl mockDAOImpl = mock(ReimbursementDAOImpl.class);
	static Reimbursement form;
	@Mock static  Reimbursement myMockEntity;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	   
		//when(mockDAOImpl.submitReimbursement(form)).thenReturn(myMockEntity);
		
		
		
	}
		

	

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testSubmitReimbursement() {
		//assertEquals(mockDAOImpl.submitReimbursement(form), myMockEntity);
	}

}
