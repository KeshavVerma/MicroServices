package com.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.entities.Product;
import com.product.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@GetMapping("/testproduct")
	public String getProduct() {
		return "Product Exist";
	}
	
	@PostMapping("/product")
	public Product saveCustomer(@RequestBody Product product) {
		return productService.saveProduct(product);
	}

}
