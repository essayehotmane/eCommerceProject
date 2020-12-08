package com.ecom.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ecom.models.Product;

public class ProductDao {
	private Connection conn;
	
	public ProductDao(Connection conn) {
		this.conn=conn;
	}
	
	public boolean categoryAdd(Product c) {
		boolean response=false;
		try {
			String query="insert into product(name, price, quantity, image, category_id) values(?,?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1, c.getName());
			ps.setFloat(2, c.getPrice());
			ps.setInt(3, c.getQuantity());
			ps.setString(4, c.getImage());
			ps.setInt(5, c.getCategory_id());
		
			ps.executeUpdate();
			response=true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return response;
	}
	
	public List<Product> getAllProducts() {
		
		  List<Product> products = new ArrayList<Product>();
		try {
			String query="select * from product";
			PreparedStatement ps=conn.prepareStatement(query);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				
				products.add(new Product(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getInt(4), rs.getString(5), rs.getInt(6)));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return products;
	}
	
	public Product getProductById(int id) {
		Product p = new Product();
		
		try {
			String query="select * from product where id=?";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setInt(1,id); 
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				p=new Product(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getInt(4), rs.getString(5), rs.getInt(6));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return p;
	}
	
	public boolean editProduct(Product pr) {
		boolean response=false;
		try {
			String query="UPDATE product SET name = ?, price = ?, quantity = ?, image = ?, category_id = ? WHERE id =?";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1,pr.getName());
			ps.setFloat(2,pr.getPrice());
			ps.setInt(3,pr.getQuantity());
			ps.setString(4,pr.getName());
			ps.setInt(5,pr.getCategory_id());
			ps.setInt(6,pr.getId());
			ps.executeUpdate();
			response=true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return response;
	}
	
	public boolean deleteProduct(int  id) {
		boolean response=false;
		try {
			String query="DELETE FROM product WHERE id = ?";
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
