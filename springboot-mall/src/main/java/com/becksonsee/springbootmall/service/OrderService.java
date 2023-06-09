package com.becksonsee.springbootmall.service;

import com.becksonsee.springbootmall.dto.CreateOrderRequest;
import com.becksonsee.springbootmall.model.Order;

public interface OrderService {

    Order getOrderById(Integer orderId);

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);


}
