package com.revature.utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Stmnt {

	public Stmnt() {
		
	}
	public static ConnFactory cf= ConnFactory.getInstance();
	Connection conn = cf.getConnection();



	 public static PreparedStatement makePrStmnt(String s) throws SQLException 
	 {  
		 Connection conn = cf.getConnection();
		 PreparedStatement prstmt = conn.prepareStatement(s);
	     return prstmt;
	 }
	 public static java.sql.ResultSet getResultSet(String sql) throws SQLException 
	 {
		 Connection conn = cf.getConnection();
	     java.sql.Statement stmt = conn.createStatement();
	     ResultSet rs = stmt.executeQuery(sql);
	     return rs;
	 }
	  
 }
	 


