/**
 * 
 */
package com.uniquemind.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uniquemind.product.model.Product;

/**
 * @author Nag
 *
 */
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
