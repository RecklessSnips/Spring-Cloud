package com.example.payment2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
@EnableDiscoveryClient
// 开启 Consul 的动态服务刷新（consul上的配置改变，本服务可以实时获取最新信息)
@RefreshScope
public class Payment2Application {

    public static void main(String[] args) {
        SpringApplication.run(Payment2Application.class, args);
    }

}
