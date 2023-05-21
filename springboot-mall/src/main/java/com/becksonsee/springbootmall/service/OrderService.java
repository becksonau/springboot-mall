package com.becksonsee.springbootmall.service;

import com.becksonsee.springbootmall.dto.CreateOrderRequest;

public interface OrderService {

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
}
