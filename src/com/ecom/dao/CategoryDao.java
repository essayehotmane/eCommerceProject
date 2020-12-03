package com.ecom.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.ecom.models.Category;
import com.ecom.models.User;


public class CategoryDao {
	private Connection conn;
	
	public CategoryDao(Connection conn) {
		this.conn=conn;
	}

	public boolean categoryAdd(Category c) {
		boolean response=false;
		try {
			String query="insert into category(name) values(?)";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1, c.getName());
		
			ps.executeUpdate();
			response=true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return response;
	}
	
	public Category getCategoryById(int id) {
		Category c = new Category();
		
		try {
			String query="select * from category where id=?";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setInt(1,id); 
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				c=new Category(rs.getInt(1), rs.getString(2));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return c;
	}
	
	public List<Category> getAllCategories() {
		
		  List<Category> categories = new ArrayList<Category>();
		try {
			String query="select * from category";
			PreparedStatement ps=conn.prepareStatement(query);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				
				categories.add(new Category(rs.getInt(1), rs.getString(2)));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return categories;
	}
	
	public boolean editCategory(Category c) {
		boolean p=false;
		try {
			String query="UPDATE category SET name = ? WHERE id =?";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1,c.getName());
			ps.setInt(2,c.getId());
			ps.executeUpdate();
			p=true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return p;
	}
	
	public boolean deleteCategory(int  id) {
		boolean response=false;
		try {
			String query="DELETE FROM category WHERE id =?";
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
