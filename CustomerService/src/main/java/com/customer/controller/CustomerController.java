package com.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.customer.common.TrasactionDTO;
import com.customer.entities.Customer;
import com.customer.services.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private CustomerService customerService;

	@GetMapping("/testcustomer")
	public String getCustomer() {
		return "Customer Exist";
	}
	
	@PostMapping("customer")
	public Customer saveCustomer(@RequestBody TrasactionDTO trasactionDTO ){
		return customerService.saveCustomer(trasactionDTO);
		
	}

	@GetMapping("/test")
	public String testService() {
		return restTemplate.getForObject("http://localhost:9091/products/product", String.class);
	}

}
