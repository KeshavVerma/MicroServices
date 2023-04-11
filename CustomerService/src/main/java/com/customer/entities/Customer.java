package com.customer.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="CUSTOMER")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	
	public Customer(String fallBackMsg) {
		super();
		this.fallBackMsg = fallBackMsg;
	}
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String address;
	private String fallBackMsg;
	
}
