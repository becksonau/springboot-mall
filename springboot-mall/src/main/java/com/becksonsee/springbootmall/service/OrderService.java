package com.becksonsee.springbootmall.service;

import com.becksonsee.springbootmall.dto.CreateOrderRequest;
import com.becksonsee.springbootmall.dto.OrderQueryParams;
import com.becksonsee.springbootmall.model.Order;

import java.util.List;

public interface OrderService {

    Integer countOrder(OrderQueryParams orderQueryParams);

    List<Order> getOrders(OrderQueryParams orderQueryParams);

    Order getOrderById(Integer orderId);

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);


}
