package com.microservice.notification_service.service;

import com.microservice.notification_service.dto.PaymentStatus;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumer {
    @KafkaListener(topics = "payment-status")
    public void sendNotification(PaymentStatus status) {

        String message = "Payment " + status.getStatus()
                + " for Order: " + status.getOrderId();

        System.out.println("Sending email to " + status.getCustomerEmail());
        System.out.println("Message: " + message);

        // call email/sms service
    }
}
