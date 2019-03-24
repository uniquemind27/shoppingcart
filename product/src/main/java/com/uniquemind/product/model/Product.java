/**
 * 
 */
package com.uniquemind.product.model;

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
public class Product {
	
	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int productId;
	
	@Column(name = "productName", unique = true, nullable = false)
	private String productName;
	
	@Column(name = "productPrice", nullable = false)
	private int productPrice;
	
	@Column(name = "category", nullable = false)
	private String category;
	
	@Column(name = "stock", nullable = false)
	private int stock;

	public Product() {
	}

	public Product(int productId, String productName, int productPrice, String category, int stock) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.category = category;
		this.stock = stock;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
}
