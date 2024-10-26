package com.example.payment.Service;

import com.example.payment.Entity.Payment;
import com.example.payment.Repository.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepo paymentRepo;

    public List<Payment> getAllPayments() {
        return paymentRepo.findAll();
    }

    public Optional<Payment> getPaymentById(Integer id) {
        return paymentRepo.findById(id);
    }

    public Payment savePayment(Payment payment) {
        return paymentRepo.save(payment);
    }

    public void deletePaymentById(Integer id) {
        paymentRepo.deleteById(id);
    }

    public boolean isPaymentDeleted(Integer id) {
        return !paymentRepo.existsById(id);
    }
}
