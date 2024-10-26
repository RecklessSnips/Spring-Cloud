package com.example.order.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/config")
public class ConfigController {

    @Value("${url.payment}")
    private static String PAYMENT_URL;
    private final RestTemplate restTemplate;

    public ConfigController(@Autowired RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @GetMapping("/getConfig")
    public ResponseEntity<String> getConfig(){
        ResponseEntity<String> info = restTemplate.getForEntity( "http://payment/config/getInfo", String.class);
        return info;
    }
}
