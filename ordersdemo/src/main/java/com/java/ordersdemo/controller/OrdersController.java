package com.java.ordersdemo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.ordersdemo.exception.ResourceNotFoundException;
import com.java.ordersdemo.model.Order;
import com.java.ordersdemo.repository.OrderRespository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/")
public class OrdersController {
	@Autowired
	private OrderRespository ordRepository;

	// get all employees
	@GetMapping("/orders")
	public List<Order> getAllOrder() {
		return ordRepository.findAll();
	}

	// create employee rest api
	@PostMapping("/orders")
	public Order createOrder(@RequestBody Order orders) {
		orders.settpit(orders.getprice_item()+orders.getgst()+orders.getquantity());
		return ordRepository.save(orders);
	}

	// get employee by id rest api
	@GetMapping("/orders/{id}")
	public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
		Order orders = ordRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Order not exist with id :" + id));
		return ResponseEntity.ok(orders);
	}

	// update employee rest api

	@PutMapping("/orders/{id}")
	public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order orderDetails) {
		Order orders = ordRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Order not exist with id :" + id));

		orders.setord_name(orderDetails.getord_name());
		orders.settpit(orderDetails.gettpit());

		Order updatedOrder = ordRepository.save(orders);
		return ResponseEntity.ok(updatedOrder);
	}

	// delete employee rest api
	@DeleteMapping("/orders/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteOrder(@PathVariable Long id) {
		Order orders = ordRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Order not exist with id :" + id));

		ordRepository.delete(orders);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}