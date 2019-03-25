/**
 * 
 */
package com.uniquemind.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uniquemind.order.model.Order;

/**
 * @author Nag
 *
 */
public interface OrderRepository extends JpaRepository<Order, Integer>{

}
