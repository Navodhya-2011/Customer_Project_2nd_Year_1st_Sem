package com.customer;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	
	private static String url = "jdbc:mysql://localhost:3306/hotel?useSSL=false";//database url
	private static String username = "root";//database username
	private static String password = "pissupoos@8960";//database password
	private static Connection con;//create database object
	
	public static Connection getConnection() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");//database driver
			
			con = DriverManager.getConnection(url, username, password);//connect to the database
		}
		catch(Exception e) {//sql exception
			System.out.println("Database connetion is not success");
		}
		
		return con;//return the connection
	}

}
