package com.revature.utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
public class DataPersistenceUtility {
	
	// I am keeping this code as an example of using generics. 
// private static final String ENDUSERFILE = "EndUserFile.txt";
// private static final String ACCOUNTFILE = "AccountFile.txt"; 
 
 
 
 private DataPersistenceUtility() {
	super();
}
/*
 public static String getEnduserfile() {
	return ENDUSERFILE;
}
public static String getAccountfile() {
	return ACCOUNTFILE;
}
//write to file 
 public static <T> void writeUtility (List<T> list , String fileName) {
	 try(ObjectOutputStream outPut = new ObjectOutputStream (new FileOutputStream(fileName))){ 
		 
		outPut.writeObject(list);
		
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}finally {
			
		}
 }
 //read from file 
 @SuppressWarnings("unchecked")
public static <T>  List<?> readUtility(String fileName){
	 List<T> list = new ArrayList<>();
	
	 try (ObjectInputStream inPut = new ObjectInputStream (new FileInputStream(fileName))) {
		
		list = (ArrayList<T>)inPut.readObject();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} finally {
		
	}
	 return list;
 }
 //update: write and read from file to return updated list.
 public static <T> List<?> updateUtility(String fileName, List<T> list){
	
	
	 return list;
 }
 */
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
 
 
 

