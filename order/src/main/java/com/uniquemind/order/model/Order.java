/**
 * 
 */
package com.uniquemind.order.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Nag
 *
 */
@Entity
public class Order {
	
	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int orderId;
	
	@Column(name = "userId", nullable = false)
	private int userId;
	
	@Column(name = "productID", nullable = false)
	private int productID;
	
	@Column(name = "orderStatus", nullable = false)
	private String orderStatus;
	
	private String payChannel;
	
	@Column(name = "orderCost", nullable = false)
	private int orderCost;
	
	public Order() {
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getPayChannel() {
		return payChannel;
	}

	public void setPayChannel(String payChannel) {
		this.payChannel = payChannel;
	}

	public int getOrderCost() {
		return orderCost;
	}

	public void setOrderCost(int orderCost) {
		this.orderCost = orderCost;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

}
