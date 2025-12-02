package com.microservice.order.service;

import com.microservice.order.dto.Order;

public interface OrderService {
    void saveOrder(Order order);
}
