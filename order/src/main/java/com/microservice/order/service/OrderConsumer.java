package com.microservice.order.service;

import com.microservice.order.dto.PaymentStatus;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    @KafkaListener(topics = "payment-status")
    public void consume(PaymentStatus status) {

        if (status.getStatus().equals("SUCCESS")) {
            System.out.println("Order saved with ID: " + status.getOrderId());
        } else {
            System.out.println("Payment failed for order: " + status.getOrderId());
        }
    }
}
