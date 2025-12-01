package com.microservice.payment.controller;

import com.microservice.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class paymentController {

    @Autowired
    PaymentService paymentService;

    @GetMapping("/hello")
    public ResponseEntity<String> getString() {
        return ResponseEntity.ok("Hello from payment servicer!");
    }

    @GetMapping("/getPaymentNotification")
    public ResponseEntity<String> getPaymentNotification() {
        return ResponseEntity.ok(paymentService.notification());
    }
}
