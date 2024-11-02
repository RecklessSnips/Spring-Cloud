package com.example.openfeign.Controller;

import com.example.API.PaymentFeign;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderCircuitController {

    @Autowired
    private PaymentFeign paymentFeign;

    @GetMapping("/feign/pay/circuit/{id}")
    @CircuitBreaker(name = "payment", fallbackMethod = "myCircuitFallBack")
    public String myCircuitBreaker(@PathVariable Integer id){
        return paymentFeign.myCircuit(id);
    }

    // 这个函数必须与主方法的参数相匹配，同时还必须接受一个 Throwable 参数来捕获异常
    public String myCircuitFallBack(Integer id, Throwable throwable){
        // 容错处理的逻辑
        return "啊哦，服务器繁忙，请稍后重试! " + id;
    }

    @GetMapping("/feign/pay/ratelimit/{id}")
    @RateLimiter(name = "payment", fallbackMethod = "myRateLimitFallback")
    public String myRateLimit(@PathVariable Integer id){
        return paymentFeign.myRateLimiter(id);
    }

    public String myRateLimitFallback(Integer id, Throwable throwable){
        return "啊哦，你被限流了!!!";
    }
}
