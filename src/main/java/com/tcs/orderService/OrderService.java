package com.tcs.orderService;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	private OrderRepository orderRepository;

	public OrderService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	public Order postOrder(Order newOrder) {
		return orderRepository.save(newOrder);
	}

	public OrderDto getOrder(Long id) {
		Order currentOrder = orderRepository.getReferenceById(id);
		return new OrderDto(currentOrder.getId(), currentOrder.getNumber(), currentOrder.getName());
	}

//	@CircuitBreaker(name = "inventoryService", fallbackMethod = "fallbackMethod")
	public String getAvailability(Long id) {
		return restTemplate().getForEntity("http://localhost:8081/inventory/" + id, String.class).getBody();
	}

	public String fallbackMethod() {
		return "Something went wrong";
	}

}
