package com.example.payment.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PayMicrometerController {

    @GetMapping("/pay/micrometer/{id}")
    public String myMicrometer(@PathVariable Integer id){
        return "Hello Micrometer, input ID: " + id;
    }
}
