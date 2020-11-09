package com.revature.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class DataPersistenceUtility {
 private static final String ENDUSERFILE = "EndUserFile.txt";
 private static final String ACCOUNTFILE = "AccountFile.txt"; 
 
 
 
 private DataPersistenceUtility() {
	super();
}
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
 
 
 
 
}
