package com.ecom.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.ecom.models.Product;
import com.ecom.models.User;



public class UserDao {
	private Connection conn;

	public UserDao(Connection conn) {
		this.conn=conn;
	}
	
	public boolean userRegister(User u) {
		boolean response=false;
		try {
			String query="insert into user(name, email, password, address, tel, role_id) values(?,?,?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1, u.getName());
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getPassword());
			ps.setString(4, u.getAddress());
			ps.setInt(5, u.getTel());
			ps.setInt(6, u.getRole_id());
			
			
			ps.executeUpdate();
			response=true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return response;
	}
	
	public User userSignIn(String email,String pass) {
		User u=null;
		try {
			String query="select * from user where email=? and password=?";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1,email);
			ps.setString(2, pass);
		
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				u=new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getInt(7));
			}
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return u;
	}
	

	
	public List<User> getAllUsers() {
		
		  List<User> users = new ArrayList<User>();
		try {
			String query="select * from user";
			PreparedStatement ps=conn.prepareStatement(query);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				
				users.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7)));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return users;
	}
	
	public boolean deleteUser(int  id) {
		boolean response=false;
		try {
			String query="DELETE FROM user WHERE id = ?";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setInt(1,id);
			ps.executeUpdate();
			response=true;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return response;
	}
}