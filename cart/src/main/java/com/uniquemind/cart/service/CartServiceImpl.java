/**
 * 
 */
package com.uniquemind.cart.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniquemind.cart.exception.CartAlreadyExistsException;
import com.uniquemind.cart.exception.CartNotFoundException;
import com.uniquemind.cart.model.Cart;
import com.uniquemind.cart.repository.CartRepository;

/**
 * @author Nag
 *
 */
@Service
public class CartServiceImpl implements CartService{
	
	private CartRepository cartRepository;

	@Autowired
	public CartServiceImpl(CartRepository cartRepository) {
		this.cartRepository = cartRepository;
	}

	@Override
	public Cart saveCart(Cart cart) throws CartAlreadyExistsException {
		return cartRepository.save(cart);
	}

	@Override
	public Cart findByUserId(int id) throws CartNotFoundException {
		Optional<Cart> optional = cartRepository.findById(id);
		if(!optional.isPresent()) {
			throw new CartNotFoundException();
		}
		return optional.get();
	}

	@Override
	public void deleteByUserId(int id) throws CartNotFoundException {
		cartRepository.deleteById(id);
	}

}