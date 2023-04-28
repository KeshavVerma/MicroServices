package com.customer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.customer.exceptions.FeignCustomErrorDecoder;

import feign.Logger;
import feign.RequestInterceptor;
import feign.codec.ErrorDecoder;
import feign.okhttp.OkHttpClient;

@Configuration
public class CustomFeignClientConfiguration {

    @Bean
    public OkHttpClient client() {
        return new OkHttpClient();
    }

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
    

    @Bean
    public ErrorDecoder errorDecoder() {
        return new FeignCustomErrorDecoder();
    }

    // Get Access token from request
    private String getBearerTokenHeader() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("Authorization");
      }
    
    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("Accept", "application/json");
            requestTemplate.header("Content-Type", "application/json");
            requestTemplate.header("X-Auth-Code", "920d4d0b85443d98d86cb3c8c81d9eed");
            //requestTemplate.header("Authorization", "Bearer " + "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICI1ajQxV21haHlhX1J0RllZZUZBZnpWbEFuYnJZSk10dHlsQUxoUnhKSUcwIn0.eyJleHAiOjE2ODI1OTc5NTAsImlhdCI6MTY4MjU5NzY1MCwianRpIjoiMmFhZGI1MjYtY2FkYi00OGQ3LTkyMWEtMGJkZThiMzgyNjE2IiwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MTgxL2F1dGgvcmVhbG1zL0N1c3RvbWVyX1Byb2R1Y3QiLCJhdWQiOiJhY2NvdW50Iiwic3ViIjoiODljYWIwNDQtZjVkMC00MDg4LWFkNzctM2RjZDJmOThiYzYyIiwidHlwIjoiQmVhcmVyIiwiYXpwIjoiQ3VzdG9tZXItUHJvZHVjdCIsInNlc3Npb25fc3RhdGUiOiJjZWUyNGQ3NS1hYjBjLTQ5NTktOWM5Mi02NzE1Y2Y5NWU3YTEiLCJhY3IiOiIxIiwicmVhbG1fYWNjZXNzIjp7InJvbGVzIjpbIm9mZmxpbmVfYWNjZXNzIiwiZGVmYXVsdC1yb2xlcy1jdXN0b21lcl9wcm9kdWN0IiwidW1hX2F1dGhvcml6YXRpb24iXX0sInJlc291cmNlX2FjY2VzcyI6eyJhY2NvdW50Ijp7InJvbGVzIjpbIm1hbmFnZS1hY2NvdW50IiwibWFuYWdlLWFjY291bnQtbGlua3MiLCJ2aWV3LXByb2ZpbGUiXX19LCJzY29wZSI6InByb2ZpbGUgZW1haWwiLCJzaWQiOiJjZWUyNGQ3NS1hYjBjLTQ5NTktOWM5Mi02NzE1Y2Y5NWU3YTEiLCJlbWFpbF92ZXJpZmllZCI6ZmFsc2UsIm5hbWUiOiJBamF5IFZlcm1hIiwicHJlZmVycmVkX3VzZXJuYW1lIjoiYWpheSIsImdpdmVuX25hbWUiOiJBamF5IiwiZmFtaWx5X25hbWUiOiJWZXJtYSJ9.LFtCs7cZT4tfqWavZ9Y8qsD6mW2OrHUL0g4uhZWaAfolMKg_Fwwurh3gjz9Xhu8LckJP-uKJXFmu2yZng4SwGBPjbENI3GJFmLLHJkZvwGMXq4Ij26zz_9_WC0CCyJ3pvCiiQ6KpU4O1YbbOdw8qX6RhiwwevKpY9yqymZtifOCfuTlBxR3rY001mfLvsNc98UW4ccfmaeRuavTMxsVFEDthEXpt4M1AqXN5E7Dt8TGhTvZ0cO1BApqNDU1TwYVmNcB_NaDn2vnXo5u6HSc60_b3x4O8M8uKDiULonIEj6eJ-_dni1rVbzPRU27RWi_AWJQqqa_Z9z_1glg6AUPCVw");
            requestTemplate.header("Authorization", getBearerTokenHeader());
        };
    }
}
