package com.kk.gw.configuration.security;

import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.web.server.SecurityWebFilterChain;

import reactor.core.publisher.Mono;

@Configuration
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity

public class SecurityConfiguration {
	
  
	@Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        http
                .authorizeExchange()
                //ALLOWING REGISTER API FOR DIRECT ACCESS
                .pathMatchers("/user/api/v1/register").permitAll()
                //ALL OTHER APIS ARE AUTHENTICATED
                .anyExchange().authenticated()
                .and()
                .csrf().disable()
                .oauth2Login()
                .and()
                .oauth2ResourceServer()
                .jwt();
        return http.build();
    }
   
	/*
	
	@Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
            .build();
    }
    */
    @Bean
    public GlobalFilter customGlobalFilter() {
        return ((exchange, chain) -> exchange.getPrincipal().map(principal -> {
            String userName = "";

            if (principal instanceof JwtAuthenticationToken) {
                //Get username from Principal
                userName = principal.getName();
            }
             //adds header to proxied request
            exchange.getRequest().mutate()
                    .header("X-Auth-Id", userName)
                    .build();
            return exchange;
        }).flatMap(chain::filter).then(Mono.fromRunnable(() -> {

        })));
    }
    
    
//    
//    @Bean
//	public ServerLogoutSuccessHandler keycloakLogoutSuccessHandler(ReactiveClientRegistrationRepository repository) {
//
//        OidcClientInitiatedServerLogoutSuccessHandler oidcLogoutSuccessHandler =
//                new OidcClientInitiatedServerLogoutSuccessHandler(repository);
//
//        //oidcLogoutSuccessHandler.setPostLogoutRedirectUri("{baseUrl}/logout.html");
//
//        return oidcLogoutSuccessHandler;
//    }
//   
}
