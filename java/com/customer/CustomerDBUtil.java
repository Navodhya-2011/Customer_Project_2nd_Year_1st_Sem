package com.customer;


import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CustomerDBUtil {
	
	private static boolean isSuccess;
	private static Connection con = null;//create database object
	private static Statement stmt = null;//create statement object
	private static ResultSet rs = null;//create database object
	
public static boolean validate(String username, String password) {
		
		try {
			con = DBConnect.getConnection();//get database connection using getConnection method
			stmt = con.createStatement();//create statement
			String sql = "select * from customer where username='"+username+"' and password='"+password+"'";
			//sql query to select all data of relevant customer
			rs = stmt.executeQuery(sql);//execute the query and assign boolean value to resultset object
			
			if (rs.next()) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}
			
		} catch (Exception e) {//if any exception occurs print relevant exception  
			e.printStackTrace();
		}
		
		return isSuccess;//return the boolean value
	}
	
	public static List<customer> getcustomer(String username){
		
		ArrayList<customer> cus = new ArrayList<>();//create an arrayList assign values from customer class
		
		try {
			con = DBConnect.getConnection();//connect to the databasse
			stmt = con.createStatement();//create a statement
			
			String sql = "select * from customer where username = '"+username+"'";
			//get all data from customer table of relevant customer
			rs = stmt.executeQuery(sql);//execute the query
			
			if(rs.next()) {//get values from customer table
				int ID = rs.getInt(1);//get id
				String name = rs.getString(2);//get name
				String email = rs.getString(3);//get email
				String phone = rs.getString(4);//get phone
				String userU = rs.getString(5);//get username
				String passU = rs.getString(6);//get password
				
				customer c = new customer(ID, name, email, phone, userU, passU);
				cus.add(c);//create customer object and assign values using constructor
			}
		}
		catch(Exception e) {//if any exception occurs, print the exception in the console 
			e.printStackTrace(); 
		}
		
		
		
		return cus;//return the customer object
	}
		
		public static boolean Insertcustomer(String name, String email, String phone, String username, String password) {
			
			boolean isSuccess = false;
			
			
			
			try {
				con = DBConnect.getConnection();//connect to the database
				stmt = con.createStatement();//create a statement
				String sql = "insert into customer values (0, '"+name+"', '"+email+"', '"+phone+"', '"+username+"', '"+password+"')";
				
				int rs = stmt.executeUpdate(sql);
				
				if(rs > 0) {
					isSuccess = true;
				}else {
					isSuccess = false;
				}
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
			return isSuccess;
		
	}
		
		public static boolean updatecustomer(String ID, String name, String email, String phone, String username, String password) {
			
			try {
				
				con = DBConnect.getConnection();//connect to the database
				stmt = con.createStatement();//create a statement
				
	    		String sql1 = "update customer set name='"+name+"', email='"+email+"', phone='"+phone+"', username='"+username+"', password='"+password+"' where ID = '"+ID+"'";		
				//create database query to update each data of each customer
	    		int rs = stmt.executeUpdate(sql1);//execute query and update database assign boolean value
				
				if(rs > 0) {//if execution is success
					isSuccess = true;
				}
				else {//if execution is unsuccess
					isSuccess = false;
				}
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
			return isSuccess;
		}
		
		public static List<customer> gecustomerDetails(String ID){//create an array list to asign value of employee class
			
			int convertedID = Integer.parseInt(ID);//convert string to integer value
			
			ArrayList<customer> cus = new ArrayList<>();
	    	
	    	try {
	    		
	    		con = DBConnect.getConnection();//connect to the details
	    		stmt = con.createStatement();//create a statement
	    		String sql = "select * from customer where ID='"+convertedID+"'";
	    		//create a sql query to select all data of relevent customer
	    		rs = stmt.executeQuery(sql);//execute query and asign valeus to resultset object
	    		
	    		while(rs.next()) {//asign values to the variables
	    			int id = rs.getInt(1);//get id
	    			String name = rs.getString(2);//get name
	    			String email = rs.getString(3);//get email
	    			String phone = rs.getString(4);//get phone
	    			String username = rs.getString(5);//get user name
	    			String password = rs.getString(6);//get password
	    			
	    			customer c = new customer(id,name,email,phone,username,password);
	    			cus.add(c);
	    		}
				
			}
			catch(Exception e) {
				e.getStackTrace();
			}
			return cus;
			
		}
		
		public static boolean deletecustomer(String ID) {
			
			int convID = Integer.parseInt(ID);//convert string value to integer value
			
			try {
				con = DBConnect.getConnection();//connect to the database
				stmt = con.createStatement();//create a statement
				String sql = "delete from customer where ID = '"+convID+"'";
				//
				int r = stmt.executeUpdate(sql);
				
				if(r > 0) {
					isSuccess = true;
				}
				else {
					isSuccess = false;
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
			return isSuccess;
		}

}
