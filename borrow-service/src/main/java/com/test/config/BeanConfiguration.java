package com.test.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
//指定为 userservice 服务，只要是调用此服务都会使用我们指定的策略
@LoadBalancerClient(value = "userservice",configuration = LoadBalancerConfig.class)
public class BeanConfiguration {
    @Bean
    @LoadBalanced()
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
