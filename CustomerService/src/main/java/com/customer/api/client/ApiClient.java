package com.customer.api.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.customer.common.Product;
import com.customer.config.CustomFeignClientConfiguration;

@FeignClient(name = "PRODUCT-SERVICE", url = "http://192.168.18.35:8989/", configuration = CustomFeignClientConfiguration.class, fallback = ApiClientFallback.class)
public interface ApiClient {

	@RequestMapping(method = RequestMethod.POST, value = "/products/product")
	Product productResponse(@RequestBody Product product);

}
