package com.microservice.payment.service;

import com.microservice.payment.httpclient.NotificationClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    NotificationClient notificationClient;

    public String notification(){
        return notificationClient.getNotification();
    }
}
