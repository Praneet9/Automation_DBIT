package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Account {
	String username="root";
	String password="mysql";
	String dbname="zymusdatabase";
	String url="jdbc:mysql://localhost:3306/";
	String driver="com.mysql.jdbc.Driver";
	Connection con;

	
	private void dbConnect() throws ClassNotFoundException, SQLException{
		Class.forName(driver);
		con = DriverManager.getConnection(url+dbname,username,password);
	}
	private void dbClose() throws SQLException{
		con.close();
	}

	
		
	
	

	
}