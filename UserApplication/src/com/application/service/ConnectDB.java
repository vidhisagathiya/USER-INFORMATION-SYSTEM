package com.application.service;


import java.sql.Connection;
import java.sql.DriverManager;



public class ConnectDB {
	public static Connection ConnectToDB() throws Exception {
	      
	      Class.forName("com.mysql.cj.jdbc.Driver");  
	      Connection con = DriverManager.getConnection("jdbc:mysql:///UserApp","root","Think@1234");
	      System.out.println("Connection established......");
	      return con;
	   }
}
