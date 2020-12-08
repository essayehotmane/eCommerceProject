package com.ecom.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ecom.models.Buy;
import com.ecom.models.Category;
import com.ecom.models.Product;

public class BuyDao {
	
private Connection conn;
	
	public BuyDao(Connection conn) {
		this.conn=conn;
	}

	public boolean orderAdd(Buy o) {
		boolean response=false;
		try {
			String query="INSERT INTO buy (quantity, total, user_id, product_id) VALUES (?, ?, ?, ?);";
			
			PreparedStatement ps=conn.prepareStatement(query);
			//ps.setDate(1, (Date) o.getDate());
			ps.setInt(1, o.getQuantity());
			ps.setFloat(2, o.getTotal());
			ps.setInt(3, o.getUser_id());
			ps.setInt(4, o.getProduct_id());
			ps.executeUpdate();
			response=true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return response;
	}
	
	public int productQuantity(int id) {
		Product p = new Product();
		int q = 0;
		
		try {
			String query="SELECT * FROM product WHERE id = ?;";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				p=new Product(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getInt(4), rs.getString(5), rs.getInt(6));
			}
			q= p.getQuantity();
			System.out.println("quantity from dao: " + q);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return q;
	}
}
