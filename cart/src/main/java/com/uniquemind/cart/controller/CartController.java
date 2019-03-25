/**
 * 
 */
package com.uniquemind.cart.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
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
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.uniquemind.cart.exception.CartAlreadyExistsException;
import com.uniquemind.cart.exception.CartNotFoundException;
import com.uniquemind.cart.exception.ProductNotFoundException;
import com.uniquemind.cart.exception.UserNotFoundException;
import com.uniquemind.cart.model.Cart;
import com.uniquemind.cart.service.CartService;

/**
 * @author Nag
 *
 */

@CrossOrigin
@RestController
@RequestMapping(path="/api/v1/cart")
public class CartController {
	
	protected Logger logger = Logger.getLogger(CartController.class.getName());
	
	private CartService cartService;
	
	private ResponseEntity<Cart> responseEntity;
	
	@Autowired
	RestTemplate restTemplate;

	@Autowired
	public CartController(CartService cartService) {
		super();
		this.cartService = cartService;
	}
	
	public CartController() {
	}
	
	@PostMapping(path="")
	public ResponseEntity<Cart> addToCart(@RequestBody Cart cart)throws CartAlreadyExistsException, ProductNotFoundException, UserNotFoundException{
		logger.info("Adding to cart");
		
		logger.info("Calling the product service to check on the productid "+cart.getProductId());
		String  productURL = "http://localhost:9070/api/v1/products/"+cart.getProductId();
	    try {
	    	ResponseEntity<Cart> productEntity = restTemplate.exchange(productURL, HttpMethod.GET, null, Cart.class);
	    	logger.info("product id check successful "+productEntity.getStatusCodeValue());
	    }catch(HttpClientErrorException e) {
	    	throw new ProductNotFoundException();
	    }
	    
		logger.info("Calling the user service to check on the userid "+cart.getUserId());
		String userURL = "http://localhost:9080/api/v1/users/"+cart.getUserId();
	    try{
	    	ResponseEntity<Cart> userEntity = restTemplate.exchange(userURL, HttpMethod.GET, null, Cart.class);
	    	logger.info("user id check successful "+userEntity.getStatusCodeValue());
	    } catch (HttpClientErrorException e) {
	    	throw new UserNotFoundException();
	    }
		
		try {
			cartService.saveCart(cart);
			responseEntity = new ResponseEntity<Cart>(cart, HttpStatus.CREATED);
		}
		catch(CartAlreadyExistsException e) {
			throw new CartAlreadyExistsException();
		}
		return responseEntity;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Cart> deleteCart(@PathVariable("id") int id) throws CartNotFoundException{
		logger.info("Deleting a cart");
		try {
			cartService.deleteByUserId(id);
			responseEntity = new ResponseEntity<Cart>(HttpStatus.OK);
		}
		catch(CartNotFoundException e){
			throw new CartNotFoundException();
		}
		return responseEntity;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cart> findCart(@PathVariable("id")int id) throws CartNotFoundException{
		logger.info("Fetching cart");
		try {
			Cart fetchedCart = cartService.findByUserId(id);
			responseEntity = new ResponseEntity<Cart>(fetchedCart, HttpStatus.OK);			
		}
		catch(CartNotFoundException e){
			throw new CartNotFoundException();
		}
		return responseEntity;
	}
	
}
