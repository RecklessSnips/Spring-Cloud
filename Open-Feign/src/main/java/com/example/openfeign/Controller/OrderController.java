package com.example.openfeign.Controller;

import com.example.API.PaymentFeign;
import com.example.DTO.PaymentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feign")
public class OrderController {

    @Autowired
    private PaymentFeign paymentFeign;

    @PostMapping("/order/add")
    PaymentDTO createPayment(@RequestBody PaymentDTO paymentDTO){
        PaymentDTO payment = paymentFeign.createPayment(paymentDTO);
        return payment;
    }

    @GetMapping("/order/getAll")
    List<PaymentDTO> getAllPayments(){
        List<PaymentDTO> allPayments = paymentFeign.getAllPayments();
        return allPayments;
    }

}
