/**
 * 
 */
package com.uniquemind.cart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Nag
 *
 */
@Entity
@Table(name="cart")
public class Cart {
	
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int cartId;
	
	@Id @Column(name = "userId", nullable = false)
	private int userId;
	
	@Column(name = "productId", nullable = false)
	private int productId;
	
	@Column(name = "productQuantity", nullable = false)
	private int productQuantity;
	
	@Column(name = "cartCost", nullable = false)
	private int cartCost;
	
	public Cart() {
	}

	public Cart(int cartId, int userId, int productId, int productQuantity, int cartCost) {
		super();
		this.cartId = cartId;
		this.userId = userId;
		this.productId = productId;
		this.productQuantity = productQuantity;
		this.cartCost = cartCost;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public int getCartCost() {
		return cartCost;
	}

	public void setCartCost(int cartCost) {
		this.cartCost = cartCost;
	}
	
}
