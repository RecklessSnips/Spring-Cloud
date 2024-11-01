package com.example.payment.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class PayCircuitController {

    @GetMapping("/pay/circuit/{id}")
    public String myCircuit(@PathVariable Integer id){
        if(id < 0){
            // 直接报错会出发熔断
            throw new RuntimeException("ID不能为负数");
        }
        else if(id > 10){
            try{
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return "Hello! Circuit ID: " + id;
    }
}
