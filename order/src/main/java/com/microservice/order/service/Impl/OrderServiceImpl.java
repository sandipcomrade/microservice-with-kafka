package com.microservice.order.service.Impl;


import com.microservice.order.dto.Order;
import com.microservice.order.dto.PaymentRequest;
import com.microservice.order.entity.OrderEntity;
import com.microservice.order.repo.OrderRepository;
import com.microservice.order.service.OrderProducer;
import com.microservice.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderProducer orderProducer;


    @Override
    public void saveOrder(Order order) {
        OrderEntity orderEntity = OrderEntity.builder()
                .orderName(order.getOrderName())
                .mobileNo(order.getMobileNo())
                .amount(order.getAmount())
                .active(true)
                .build();
        OrderEntity orderEntity1 = orderRepository.save(orderEntity);
        PaymentRequest paymentRequest=PaymentRequest.builder()
                .orderId(orderEntity1.getOrderId())
                .amount(orderEntity1.getAmount())
                .mobileNo(orderEntity1.getMobileNo())
                .build();
        orderProducer.sendPaymentRequest(paymentRequest);
    }


}
