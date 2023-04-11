package com.kk.gw.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringHystrixFallBackConfig {

	@Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/customers/**")
                		.filters(f -> f.circuitBreaker(h -> h.setName("Hystrix")
                				.setFallbackUri("forward:/customerFallBack")))
                        .uri("lb://CUSTOMER-SERVICE"))
                        //.id("employeeModule"))
                
                .route(r -> r.path("/products/**")
                		.filters(f -> f.circuitBreaker(h -> h.setName("Hystrix")
                				.setFallbackUri("forward:/productFallBack")))
                        .uri("lb://PRODUCT-SERVICE"))
                        //.id("consumerModule"))
                
                .build();
    }
}
