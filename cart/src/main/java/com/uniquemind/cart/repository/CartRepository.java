/**
 * 
 */
package com.uniquemind.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uniquemind.cart.model.Cart;

/**
 * @author Nag
 *
 */
public interface CartRepository extends JpaRepository<Cart, Integer> {

}
