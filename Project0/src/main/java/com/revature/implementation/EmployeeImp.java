package com.revature.implementation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.DAOInterface.EmployeeInterface;
import com.revature.model.Employee;
import com.revature.model.EndUser;
import com.revature.utility.BankLogger;
import com.revature.utility.DataPersistenceUtility;

public class EmployeeImp implements EmployeeInterface {
	private static List<Employee>	employeeList = new ArrayList<Employee>();

	
	public static List<Employee> getEmployeeList(){
		return employeeList;
	}
	
	
	
	public static Employee lookUpBYID(int employeeID) {
		for (EndUser eu : EndUserImp.endUserList)
			if (eu instanceof Employee) {
				if (((Employee) eu).getEmployeeID() == employeeID){
					return (Employee) eu;
				}
			}
		return null;
	}
	public static void fillEmployeeList() {
   employeeList.clear();
		
		String sql= "select employee_id, first_name, last_name, is_active, user_name, "
				+ "password, position from project0.employee";
		
		try {
			int id;
			String fnm, lnm,un, pw, pos; 
			boolean act;
			
			ResultSet rs = DataPersistenceUtility.getResultSet(sql);
			while (rs.next()) {
			id= rs.getInt("employee_id");
			fnm= rs.getString("first_name");
			lnm = rs.getString("last_name");
			un = rs.getString("user_name");
			pw = rs.getString("password");
			pos = rs.getString("position");
			act = rs.getBoolean("is_active");
			Employee ex = new Employee(fnm, lnm, un, pw, act,id,pos);
			getEmployeeList().add(ex);	
			}			
			
		} catch (SQLException e) {
			System.out.println("Check EmployeeList SQL"  +e.getSQLState() + e.getMessage());
			e.printStackTrace();
		}
		
		}
			
		
	
	@Override
	public void createNewEmployee(Employee ex) {
		String sql = "Insert into project0.employee (first_name,last_name, user_name, password,position, is_active) values (?,?,?,?,?,?)";	
				try {
					PreparedStatement stmnt = DataPersistenceUtility.makePrStmnt(sql);
					stmnt.setString(1, ex.getfName());
					stmnt.setString(2, ex.getfName());
					stmnt.setString(3, ex.getfName());
					stmnt.setString(4, ex.getfName());
					stmnt.setString(5, ex.getfName());
					stmnt.setBoolean(6, true);
					stmnt.executeUpdate();
					
					fillEmployeeList();
					BankLogger.LogIt("info","A new employee was registered " + ex.getUserName() +".");
				}catch(SQLException sqe){
			          System.out.println("Check Employee Insert SQL " + sqe.getSQLState() + sqe.getMessage());
			        } catch (Exception e) {
			            System.out.println("Error:" +e.getMessage());
			         }
		
	}

	

	@Override
	public void updateEmployee(Employee ex) {
		 String sql = "UPDATE project0.employee  SET  first_name = ?, last_name = ?," +
		            " user_name = ?, password = ?, position = ? , is_active = ? WHERE employee_id = ?";
		       
		        try {
		        	PreparedStatement stmnt = DataPersistenceUtility.makePrStmnt(sql);
		            stmnt.setString(1,ex.getfName());
		            stmnt.setString(2,ex.getlName());
		            stmnt.setString(3,ex.getUserName());
		            stmnt.setString(4, ex.getPassword());
		            stmnt.setString(5,ex.getPosition());
		            stmnt.setBoolean(6, ex.isActive());
		            stmnt.setInt(7, ex.getEmployeeID());
		            stmnt.executeUpdate();
		            
		            fillEmployeeList();
		         } catch(SQLException sqe){
		          System.out.println("Check Employee Update SQL " + sqe.getSQLState() + sqe.getMessage());
		        } catch (Exception e) {
		            System.out.println("Error:" +e.getMessage());
		         }
		
	}

	@Override
	public void deactivateEmployee(Employee ex) {
		 String sql= "DELETE from project0.employee  WHERE employee_id = ? ";
	     
	     try {
	    	 PreparedStatement stmnt = DataPersistenceUtility.makePrStmnt(sql);
	             stmnt.setInt(1,ex.getEmployeeID());
	             stmnt.executeUpdate();
	             
	             fillEmployeeList();
	        } catch(SQLException sqe){
	          System.out.println("Check Employee DELETE SQL " + sqe.getSQLState() + sqe.getMessage());
	        } catch (Exception e) {
	            System.out.println("Error:" +e.getMessage());
	         }
		
	}

}
