package com.kk.gw.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class FallBackController {
	
	@RequestMapping("/customerFallBack")
	public Mono<String> customerServiceFallBack() {
		return Mono.just("Customer Service is Down, Please Try later!");
	}
	
	@RequestMapping("/productFallBack")
	public Mono<String> productServiceFallBack() {
		return Mono.just("Product Service is Down, Please Try later!");
	}

}
