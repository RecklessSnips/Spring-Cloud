package com.example.payment.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
public class ConfigController {

    @Value("${server.port}")
    private Integer port;

    @GetMapping("/getInfo")
    public String getConfig(@Value("${payment.info}") String info){
        return info + ", Running on port: " + port;
    }

    @GetMapping("/getPort")
    public String getPort(){
        return "Running on port: " + port;
    }
}
