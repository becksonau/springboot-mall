package com.becksonsee.springbootmall.controller;

import com.becksonsee.springbootmall.dto.CreateOrderRequest;
import com.becksonsee.springbootmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/users/{userId}/orders")       // 表達：使用者/要有使用者帳號的前提/才有訂購創建訂單行為
    public ResponseEntity<?> createOrder(@PathVariable Integer userId,
                                         @RequestBody CreateOrderRequest createOrderRequest) {
        orderService.createOrder(userId, createOrderRequest);

        return  ResponseEntity.status(HttpStatus.CREATED).body(userId);
    }

}
