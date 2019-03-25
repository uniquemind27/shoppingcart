/**
 * 
 */
package com.uniquemind.order.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uniquemind.order.exception.OrderFailureException;
import com.uniquemind.order.exception.OrderNotFoundException;
import com.uniquemind.order.model.Order;
import com.uniquemind.order.service.OrderService;

/**
 * @author Nag
 *
 */
@RestController
@CrossOrigin
@RequestMapping(path="/api/v1/orders")
public class OrderController {

	protected Logger logger = Logger.getLogger(OrderController.class.getName());
	
	private OrderService orderService;
	
	private ResponseEntity<Order> responseEntity;
	
	public OrderController() {
		super();
	}

	@Autowired
	public OrderController(OrderService orderService) {
		super();
		this.orderService = orderService;
	}

	@PostMapping(path="")
	public ResponseEntity<Order> placeOrder(@RequestBody Order order) throws OrderFailureException{
		logger.info("Placing an Order");
		try {
			orderService.saveOrder(order);
			responseEntity = new ResponseEntity<Order>(order, HttpStatus.CREATED);
		}
		catch(OrderFailureException e) {
			throw new OrderFailureException();
		}
		return responseEntity;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Order> findOrder(@PathVariable("id")int id) throws OrderNotFoundException{
		logger.info("Fetching an Order");
		try {
			Order fetchedOrder = orderService.findByOrderId(id);
			responseEntity = new ResponseEntity<Order>(fetchedOrder, HttpStatus.OK);			
		}
		catch(OrderNotFoundException e){
			throw new OrderNotFoundException();
		}
		return responseEntity;
	}
	
	@GetMapping("/all")
	public List<Order> findAllOrders() throws OrderNotFoundException{
		logger.info("Fetching all orders");
		List<Order> orders = new ArrayList<Order>();
		try {
			orders = orderService.findAllOrders();
			responseEntity = new ResponseEntity<Order>(HttpStatus.ACCEPTED);
		}
		catch(OrderNotFoundException e) {
			throw new OrderNotFoundException();
		}
		return orders;
	}

}
