package com.tcs.orderService;

import lombok.Data;

@Data
public class OrderDto {
	private Long id;
	private Long number;
	private String name;

	public OrderDto() {

	}

	public OrderDto(Long id, Long number, String name) {
		this.id = id;
		this.name = name;
		this.number = number;
	}
}
