package com.customer.common;

import com.customer.entities.Customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrasactionDTO {
	
	private Customer customer;
	private Product product;

}
