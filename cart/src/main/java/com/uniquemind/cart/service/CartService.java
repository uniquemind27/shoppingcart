/**
 * 
 */
package com.uniquemind.cart.service;

import com.uniquemind.cart.exception.CartAlreadyExistsException;
import com.uniquemind.cart.exception.CartNotFoundException;
import com.uniquemind.cart.model.Cart;

/**
 * @author Nag
 *
 */
public interface CartService
{
	Cart saveCart(Cart cart) throws CartAlreadyExistsException;
	Cart findByUserId(int id) throws CartNotFoundException;
	void deleteByUserId(int id) throws CartNotFoundException;
}