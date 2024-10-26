package com.example.DTO;

import java.io.Serializable;
import java.math.BigDecimal;

public class PaymentDTO implements Serializable {

    private String payNo;
    private String orderNo;
    private Integer userId;
    private BigDecimal amount;

    public PaymentDTO() {
    }

    public PaymentDTO(String payNo, String orderNo, Integer userId, BigDecimal amount) {
        this.payNo = payNo;
        this.orderNo = orderNo;
        this.userId = userId;
        this.amount = amount;
    }

    public String getPayNo() {
        return payNo;
    }

    public void setPayNo(String payNo) {
        this.payNo = payNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "PaymentDTO{" +
                "payNo='" + payNo + '\'' +
                ", orderNo='" + orderNo + '\'' +
                ", userId=" + userId +
                ", amount=" + amount +
                '}';
    }
}
