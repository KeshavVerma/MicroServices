package com.customer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.customer.common.Product;
import com.customer.common.TrasactionDTO;
import com.customer.entities.Customer;
import com.customer.repositories.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private RestTemplate restTemplate;

	public TrasactionDTO saveCustomer(TrasactionDTO trasactionDTO) {
		
		Customer customer = trasactionDTO.getCustomer();
		Product product = trasactionDTO.getProduct();
		customer= customerRepository.save(customer);
		product.setCustomer_id(customer.getId());		
		Product productResponse = restTemplate.postForObject("http://PRODUCT-SERVICE/products/product", product, Product.class);
		return new TrasactionDTO(customer,productResponse);
	}

}
