package com.customer.api.client;

import org.springframework.stereotype.Component;

import com.customer.common.Product;

@Component
public class ApiClientFallback implements ApiClient {

	@Override
	public Product productResponse(Product product) {
		return new Product("Product Service is Down!");
	}

}
