package com.tcs.orderService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
	private OrderService orderService;

	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}

	@PostMapping
	public Order postOrder(@RequestBody Order newOrder) {
		return orderService.postOrder(newOrder);
	}

	@GetMapping("/{id}")
	public OrderDto getOrder(@PathVariable("id") Long id) {
		return orderService.getOrder(id);
	}

	@GetMapping("/inventoryAvailable/{id}")
	public String getInventoryAvailability(@PathVariable("id") Long id) {
		return orderService.getAvailability(id);
	}
}
