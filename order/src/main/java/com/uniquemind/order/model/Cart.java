/**
 * 
 */
package com.uniquemind.order.model;

/**
 * @author Nag
 *
 */
public class Cart {
	
	private int cartId;
	
	private int userId;
	
	private int productId;
	
	private int productQuantity;
	
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
