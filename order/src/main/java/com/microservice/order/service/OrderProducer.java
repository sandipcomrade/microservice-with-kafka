package com.microservice.order.service;

import com.microservice.order.dto.PaymentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void sendPaymentRequest(PaymentRequest request) {
        kafkaTemplate.send("payment-request", request);
    }
}
