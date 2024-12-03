package com.example.openfeign.Controller;

import com.example.API.OrderFeign;
import com.example.DTO.PaymentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/feign/gateway")
public class GatewayController {

    @Autowired
    private OrderFeign orderFeign;

    @GetMapping("/getAll")
    ResponseEntity<List<PaymentDTO>> getAllPaymentsGateway(){
        ResponseEntity<List<PaymentDTO>> allPaymentsGateway = orderFeign.getAllPaymentsGateway();
        return allPaymentsGateway;
    }

    @GetMapping("/info")
    ResponseEntity<String> getInfo(){
        ResponseEntity<String> info = orderFeign.getInfo();
        return info;
    }
}
