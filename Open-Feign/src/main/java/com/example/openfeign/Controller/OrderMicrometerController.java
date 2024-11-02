package com.example.openfeign.Controller;

import com.example.API.PaymentFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderMicrometerController {

    @Autowired
    PaymentFeign paymentFeign;

    @GetMapping("/feign/micrometer/{id}")
    public String myMicrometer(@PathVariable Integer id){
        return paymentFeign.myMicrometer(id);
    }
}
