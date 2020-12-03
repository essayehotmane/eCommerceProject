package com.ecom.bdd;
import java.sql.*;


public class Database_connection {

public static Connection conn ;
	
	public static Connection GetConnection() {
		try {
			if(conn==null) {
				Class.forName("com.mysql.jdbc.Driver");
				conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecom-jee", "root", "");
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

}

