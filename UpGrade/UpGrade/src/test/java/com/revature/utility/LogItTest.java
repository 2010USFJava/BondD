package com.revature.utility;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LogItTest {

	
	@Test
	public void testLogIt() throws SQLException {
		LogIt.logIt("info", "Testing Logger");
	}

	
}
