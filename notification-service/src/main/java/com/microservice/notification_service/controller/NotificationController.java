package com.microservice.notification_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class NotificationController {
    @GetMapping("/get")
    public ResponseEntity<String> getString(){
        return ResponseEntity.ok("This is a simple notification");
    }
}
