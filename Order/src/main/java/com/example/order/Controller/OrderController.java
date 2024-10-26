package com.example.order.Controller;

import com.example.DTO.PaymentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final RestTemplate restTemplate;

//    private static final String PAYMENT_URL = "http://localhost:8080";
    // 注册服务后不需要写死domain和端口
    @Value("${url.payment}")
    private static String PAYMENT_URL;

    public OrderController(@Autowired RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @PostMapping("/add")
    public ResponseEntity<PaymentDTO> addOrder(@RequestBody PaymentDTO paymentDTO){
        // 这个返回值由所调用接口的返回值决定，也就是 PaymentController 对应的endpoint返回值
        ResponseEntity<PaymentDTO> entity = restTemplate.postForEntity(PAYMENT_URL + "/add", paymentDTO, PaymentDTO.class);
        System.out.println(entity);
        System.out.println(entity.getHeaders());
        // 这里返回的type是 PaymentDTO
        System.out.println(entity.getBody());
        System.out.println(entity.getStatusCode());
        // 将entity作为ResponseEntity返回
        return entity;
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteOrder(@PathVariable Integer id){
//        restTemplate.delete(PAYMENT_URL + "/delete/" + id);
        // 使用exchange方法来发送DELETE请求，并期望返回一个Boolean类型的响应
        ResponseEntity<Boolean> response = restTemplate.exchange(
                PAYMENT_URL + "/delete/" + id,
                HttpMethod.DELETE,
                null,  // DELETE请求通常没有请求体
                new ParameterizedTypeReference<>() {
                }  // 定义期望的响应体类型
        );
        return response;
    }

    @GetMapping("/getOrder/{id}")
    public ResponseEntity<PaymentDTO> getPaymentById(@PathVariable Integer id) {
        // 调用 payment 服务的 get 接口
        ResponseEntity<PaymentDTO> response = restTemplate.getForEntity(PAYMENT_URL + "/get/" + id, PaymentDTO.class);
        return response;
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

}
