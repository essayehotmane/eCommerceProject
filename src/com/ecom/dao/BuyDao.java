package com.ecom.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import com.ecom.models.Buy;

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
}
