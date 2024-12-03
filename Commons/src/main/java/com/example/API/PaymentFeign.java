package com.example.API;

import com.example.DTO.PaymentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

// 调用哪个微服务
@FeignClient("payment")
public interface PaymentFeign {
    // 调用 Payment 服务的接口，但不是通过 restTemplate
    @PostMapping("/add")
    PaymentDTO createPayment(@RequestBody PaymentDTO paymentDTO);

    @GetMapping("/getAll")
    List<PaymentDTO> getAllPayments();

    // Feign 天生支持 Load Balance
    @GetMapping("/config/getInfo")
    String getConfig();

    // 测试 resilience4J
    @GetMapping("/pay/circuit/{id}")
    String myCircuit(@PathVariable Integer id);

    // 测试 Rate Limiter
    @GetMapping("/pay/ratelimit/{id}")
    String myRateLimiter(@PathVariable Integer id);

    // 测试 Micrometer
    @GetMapping("/pay/micrometer/{id}")
    String myMicrometer(@PathVariable Integer id);
}
