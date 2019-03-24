/**
 * 
 */
package com.uniquemind.product.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uniquemind.product.exception.ProductAlreadyExistsException;
import com.uniquemind.product.exception.ProductNotFoundException;
import com.uniquemind.product.model.Product;
import com.uniquemind.product.service.ProductService;

/**
 * @author Nag
 *
 */
@CrossOrigin
@RestController
@RequestMapping(path="/api/v1/products")
public class ProductController {
	
	protected Logger logger = Logger.getLogger(ProductController.class.getName());
	
	private ProductService productService;
	
	private ResponseEntity<Product> responseEntity;

	@Autowired
	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}
	
	public ProductController() {
	}
	
	@PostMapping(path="")
	public ResponseEntity<Product> registerProduct(@RequestBody Product product)throws ProductAlreadyExistsException{
		logger.info("Registering an Product");
		try {
			productService.saveProduct(product);
			responseEntity = new ResponseEntity<Product>(product, HttpStatus.CREATED);
		}
		catch(ProductAlreadyExistsException e) {
			throw new ProductAlreadyExistsException();
		}
		return responseEntity;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Product> deleteProduct(@PathVariable("id") int id) throws ProductNotFoundException{
		logger.info("Deleting an Product");
		try {
			productService.deleteByProductId(id);
			responseEntity = new ResponseEntity<Product>(HttpStatus.OK);
		}
		catch(ProductNotFoundException e){
			throw new ProductNotFoundException();
		}
		return responseEntity;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> findUser(@PathVariable("id")int id) throws ProductNotFoundException{
		logger.info("Fetching an Product");
		try {
			Product fetchedProduct = productService.findByProductId(id);
			responseEntity = new ResponseEntity<Product>(fetchedProduct, HttpStatus.OK);			
		}
		catch(ProductNotFoundException e){
			throw new ProductNotFoundException();
		}
		return responseEntity;
	}
	
	@GetMapping("/all")
	public List<Product> findAllUsers() throws ProductNotFoundException{
		logger.info("Fetching all products");
		List<Product> products = new ArrayList<Product>();
		try {
			products = productService.findAllProducts();
			responseEntity = new ResponseEntity<Product>(HttpStatus.ACCEPTED);
		}
		catch(ProductNotFoundException e) {
			throw new ProductNotFoundException();
		}
		return products;
	}
}
