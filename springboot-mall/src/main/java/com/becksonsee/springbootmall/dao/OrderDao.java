package com.becksonsee.springbootmall.dao;

import com.becksonsee.springbootmall.dto.OrderQueryParams;
import com.becksonsee.springbootmall.model.Order;
import com.becksonsee.springbootmall.model.OrderItem;

import java.util.List;

public interface OrderDao {

    Integer countOrder(OrderQueryParams orderQueryParams);

    List<Order> getOrders(OrderQueryParams orderQueryParams);

    Order getOrderById(Integer orderId);

    List<OrderItem> getOrderItemsByOrderId(Integer orderId);

    Integer createOrder(Integer userId, Integer totalAmount);

    void createOrderItems(Integer orderId, List<OrderItem> orderItemList);
}
