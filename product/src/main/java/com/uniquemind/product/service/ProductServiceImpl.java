/**
 * 
 */
package com.uniquemind.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniquemind.product.exception.ProductAlreadyExistsException;
import com.uniquemind.product.exception.ProductNotFoundException;
import com.uniquemind.product.model.Product;
import com.uniquemind.product.repository.ProductRepository;

/**
 * @author Nag
 *
 */
@Service
public class ProductServiceImpl implements ProductService {
	
	private ProductRepository productRepository;

	@Autowired
	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public Product saveProduct(Product product) throws ProductAlreadyExistsException {
		return productRepository.save(product);
	}

	@Override
	public Product findByProductId(int id) throws ProductNotFoundException {
		Optional<Product> optional = productRepository.findById(id);
		if(!optional.isPresent()) {
			throw new ProductNotFoundException();
		}
		return optional.get();
	}

	@Override
	public void deleteByProductId(int id) throws ProductNotFoundException {
		productRepository.deleteById(id);
	}

	@Override
	public List<Product> findAllProducts() throws ProductNotFoundException {
		return productRepository.findAll();
	}

}
