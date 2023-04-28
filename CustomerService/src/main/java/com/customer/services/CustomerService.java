package com.customer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.customer.api.client.ApiFeignClient;
import com.customer.common.Product;
import com.customer.common.TrasactionDTO;
import com.customer.entities.Customer;
import com.customer.repositories.CustomerRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private  ApiFeignClient apiClient;

	public TrasactionDTO saveCustomer(TrasactionDTO trasactionDTO) {
		log.info("Customer*****************************");
		Customer customer = trasactionDTO.getCustomer();
		Product product = trasactionDTO.getProduct();
		customer= customerRepository.save(customer);
		product.setCustomer_id(customer.getId());	
		
		Product productResponse = apiClient.productResponse(product);
		//Product productResponse = restTemplate.postForObject("http://product-service/products/product", product, Product.class);
		/*ResponseEntity<Product> productResponse = restTemplate.getForEntity("http://PRODUCT-SERVICE/products/product", Product.class , product);
		if (productResponse.getStatusCode() == HttpStatus.OK) {
            return Optional.ofNullable(productResponse.getBody());
        } else {
            log.error("Unable to get inventory level for product: " + product + ", StatusCode: " + productResponse.getStatusCode());
            return Optional.empty();
        }*/
		return new TrasactionDTO(customer,productResponse);
	}

}
