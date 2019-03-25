/**
 * 
 */
package com.uniquemind.order.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniquemind.order.exception.OrderFailureException;
import com.uniquemind.order.exception.OrderNotFoundException;
import com.uniquemind.order.model.Order;
import com.uniquemind.order.repository.OrderRepository;

/**
 * @author Nag
 *
 */
@Service
public class OrderServiceImpl implements OrderService{

	private OrderRepository orderRepository;

	@Autowired
	public OrderServiceImpl(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}


	@Override
	public Order saveOrder(Order order) throws OrderFailureException {
		return orderRepository.save(order);
	}


	@Override
	public Order findByOrderId(int id) throws OrderNotFoundException {
		Optional<Order> optional = orderRepository.findById(id);
		if(!optional.isPresent()) {
			throw new OrderNotFoundException();
		}
		return optional.get();
	}


	@Override
	public List<Order> findAllOrders() throws OrderNotFoundException {
		return orderRepository.findAll();
	}
	
}
