package com.example.payment.Controller;

import com.example.DTO.PaymentDTO;
import com.example.payment.Entity.Payment;
import com.example.payment.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private DateTimeFormatter dateTimeFormatter;

    @PostMapping("/add")
    public PaymentDTO createPayment(@RequestBody PaymentDTO paymentDTO) {
        // 将DTO转换成实体 Payment
        Payment payment = new Payment(paymentDTO);
        // 格式化时间
        LocalDateTime time = LocalDateTime.now();
        String formattedTime = dateTimeFormatter.format(time);
        // 手动设置其他 fields
        payment.setCreateTime(formattedTime);
        payment.setUpdateTime(formattedTime);
        Payment savedPayment = paymentService.savePayment(payment);

        return new PaymentDTO(
            savedPayment.getPayNo(),
            savedPayment.getOrderNo(),
            savedPayment.getUserId(),
            savedPayment.getAmount()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deletePayment(@PathVariable Integer id) {
        paymentService.deletePaymentById(id);
        boolean ifDeleted = paymentService.isPaymentDeleted(id);
        return ifDeleted
                ? ResponseEntity.ok(true)
                : ResponseEntity.notFound().build();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<PaymentDTO> getPaymentById(@PathVariable Integer id) {
        Optional<Payment> payment = paymentService.getPaymentById(id);
        if (payment.isPresent()) {
            Payment payment1 = payment.get();
            PaymentDTO paymentDTO = new PaymentDTO(
                    payment1.getPayNo(),
                    payment1.getOrderNo(),
                    payment1.getUserId(),
                    payment1.getAmount()
            );
            return ResponseEntity.ok(paymentDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getAll")
    public List<PaymentDTO> getAllPayments() {
        List<Payment> allPayments = paymentService.getAllPayments();
        List<PaymentDTO> paymentDTOS = allPayments.stream()
                .map(
                    payment -> new PaymentDTO(
                        payment.getPayNo(),
                        payment.getOrderNo(),
                        payment.getUserId(),
                        payment.getAmount()
                )).toList();

        return paymentDTOS;
    }
}
