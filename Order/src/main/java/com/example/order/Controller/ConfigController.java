package com.example.order.Controller;

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

    @Value("${url.payment}")
    private static String PAYMENT_URL;

    @Autowired
    private DiscoveryClient discoveryClient;

    private final RestTemplate restTemplate;

    public ConfigController(@Autowired RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @GetMapping("/getConfig")
    public ResponseEntity<String> getConfig(){
        ResponseEntity<String> info = restTemplate.getForEntity( "http://payment/config/getInfo", String.class);
        return info;
    }

    @GetMapping("/discovery")
    public String discoveryClient(){
        List<String> services = discoveryClient.getServices();
        System.out.println("Description: " + discoveryClient.description());
        for(String element: services){
            System.out.println(element);
        }
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        List<ServiceInstance> instances = discoveryClient.getInstances("payment");
        for(ServiceInstance instance: instances){
            System.out.println(instance.getInstanceId());
            System.out.println(instance.getHost());
            System.out.println(instance.getPort());
            System.out.println(instance.getServiceId());
            System.out.println(instance.getUri());
        }
        return "See the terminal for more details";
    }
}
