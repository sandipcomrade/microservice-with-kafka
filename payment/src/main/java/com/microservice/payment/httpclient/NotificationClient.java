package com.microservice.payment.httpclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "NOTIFICATION-SERVICE", path = "/api")
public interface NotificationClient {

    @GetMapping("/getNotification")
    String getNotification();

}
