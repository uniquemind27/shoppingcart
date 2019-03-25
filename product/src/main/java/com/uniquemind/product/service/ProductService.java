/**
 * 
 */
package com.uniquemind.product.service;

import java.util.List;

import com.uniquemind.product.exception.ProductAlreadyExistsException;
import com.uniquemind.product.exception.ProductNotFoundException;
import com.uniquemind.product.model.Product;

/**
 * @author Nag
 *
 */
public interface ProductService {

	Product saveProduct(Product product) throws ProductAlreadyExistsException;
	Product findByProductId(int id) throws ProductNotFoundException;
	void deleteByProductId(int id) throws ProductNotFoundException;
	List<Product> findAllProducts() throws ProductNotFoundException;
//	Product updateProduct(int id) throws ProductNotFoundException;
}
