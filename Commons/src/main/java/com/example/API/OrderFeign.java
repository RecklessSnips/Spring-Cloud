package com.example.API;

import com.example.DTO.PaymentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

// 为了让 open feign 正确进入gateway，这里不能直接调用Order了，而是让gateway去找order
//@FeignClient("order")
@FeignClient(value = "Gateway")
public interface OrderFeign {

    // 测试Gateway
    @GetMapping("/gateway/getAll")
    ResponseEntity<List<PaymentDTO>> getAllPaymentsGateway();

    @GetMapping("/gateway/info")
    ResponseEntity<String> getInfo();
}
