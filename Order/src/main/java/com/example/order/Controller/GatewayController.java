package com.example.order.Controller;

import com.example.DTO.PaymentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;

/*
    测试gateway的
 */
@RestController
@RequestMapping("/gateway")
public class GatewayController {

    private final RestTemplate restTemplate;

    @Value("${url.payment}")
    private String PAYMENT_URL;

    public GatewayController(@Autowired RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<PaymentDTO>> getAllPayments() {
        // 调用 payment 服务的 getAll 接口
        ResponseEntity<List<PaymentDTO>> response = restTemplate.exchange(
                PAYMENT_URL + "/getAll",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                });
        return response;
    }

    @GetMapping("/info")
    public ResponseEntity<String> getInfo(){
        return new ResponseEntity<>("Gateway running at: " + new Date(System.currentTimeMillis()), HttpStatusCode.valueOf(200));
    }
}
