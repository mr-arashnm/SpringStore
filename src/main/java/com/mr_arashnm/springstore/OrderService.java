package com.mr_arashnm.springstore;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
public class OrderService {
    private PaymentService paymentService;


    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
        System.out.println("Order Service created");
    }

    @PostConstruct
    public void init() {
        System.out.println("Order Service PostConstruct");
    }

    @PreDestroy
    public void cleanup() {
        System.out.println("Order Service PreDestroy");
    }

    public void placeOrder() {
        paymentService.processPayment(10);
    }

    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
}
