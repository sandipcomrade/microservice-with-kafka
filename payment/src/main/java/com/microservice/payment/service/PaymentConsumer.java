package com.microservice.payment.service;

import com.microservice.payment.dto.PaymentRequest;
import com.microservice.payment.dto.PaymentStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PaymentConsumer {
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @KafkaListener(topics = "payment-request")
    public void processPayment(PaymentRequest request) {

        System.out.println("Processing payment for: " + request.getOrderId());

        PaymentStatus status = new PaymentStatus();
        status.setOrderId(request.getOrderId());
        status.setCustomerEmail(request.getCustomerEmail());
        status.setStatus("SUCCESS"); // mock success

        // send result to Kafka
        kafkaTemplate.send("payment-status", status);
    }
}
