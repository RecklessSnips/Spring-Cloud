package com.example.openfeign.Controller;

import com.example.API.PaymentFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/config")
public class ConfigController {

    @Autowired
    private PaymentFeign paymentFeign;

    // Feign 天生支持 Load Balance
    @GetMapping("/getInfo")
    public String getConfig() {
        String config = paymentFeign.getConfig();
        return config;
    }
}
