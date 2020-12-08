package com.ecom.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import com.ecom.models.Order;

public class OrderDao {
	
private Connection conn;
	
	public OrderDao(Connection conn) {
		this.conn=conn;
	}

	public boolean orderAdd(Order o) {
		boolean response=false;
		try {
			String query="INSERT INTO order (quantity,total,user_id,product_id) VALUES (?,?,?,?)";
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
}
