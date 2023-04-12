package com.customer.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	
	public Product(String fallBackMsg) {
		super();
		this.fallBackMsg = fallBackMsg;
	}
	private int id;
	private String name;
	private String type;
	private int quantity;
	private double price;
	private int customer_id;
	private String fallBackMsg;

}
