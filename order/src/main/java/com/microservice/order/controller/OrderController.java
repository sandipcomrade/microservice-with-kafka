package com.microservice.order.controller;

import com.microservice.order.dto.Order;
import com.microservice.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/save-order")
    public ResponseEntity<String> saveOrder(@RequestBody Order order){
        orderService.saveOrder(order);
        return ResponseEntity.ok("Order saved successfully");
    }
}
