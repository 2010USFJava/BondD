package com.revature.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class MasterServletTest {

	@Mock
    HttpServletRequest request;
 
    @Mock
    HttpServletResponse response;
 
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDoGetHttpServletRequestHttpServletResponse() {
		
	}

	@Test
	public void testDoPostHttpServletRequestHttpServletResponse() {
		
	}

}
