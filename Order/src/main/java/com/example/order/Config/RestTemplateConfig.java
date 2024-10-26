package com.example.order.Config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Bean
    @LoadBalanced
    // Consul默认支持负载均衡，，默认有多个实例，必须加上才能启动服务发现
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
