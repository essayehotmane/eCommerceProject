package com.ecom.models;
import java.util.Date;

public class Order {
	private int id;
	private int quantity;
	private float total;
	private int user_id;
	private int product_id;
	
	public Order() {
		super();
	}
	
	public Order(int quantity, float total, int user_id, int product_id) {
		super();
		this.quantity = quantity;
		this.total = total;
		this.user_id = user_id;
		this.product_id = product_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	

}
