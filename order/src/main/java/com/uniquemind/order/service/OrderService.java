/**
 * 
 */
package com.uniquemind.order.service;

import java.util.List;

import com.uniquemind.order.exception.OrderFailureException;
import com.uniquemind.order.exception.OrderNotFoundException;
import com.uniquemind.order.model.Order;

/**
 * @author Nag
 *
 */

public interface OrderService {
	Order saveOrder(Order order) throws OrderFailureException;
	Order findByOrderId(int id) throws OrderNotFoundException;
	List<Order> findAllOrders() throws OrderNotFoundException;
}
