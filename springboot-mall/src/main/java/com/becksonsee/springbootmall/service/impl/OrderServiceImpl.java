package com.becksonsee.springbootmall.service.impl;

import com.becksonsee.springbootmall.dao.OrderDao;
import com.becksonsee.springbootmall.dao.ProductDao;
import com.becksonsee.springbootmall.dto.BuyItem;
import com.becksonsee.springbootmall.dto.CreateOrderRequest;
import com.becksonsee.springbootmall.model.OrderItem;
import com.becksonsee.springbootmall.model.Product;
import com.becksonsee.springbootmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ProductDao productDao;

    @Transactional      // 多張 table 要用 @Transactional 確保此兩張 table 同時啟動
    @Override
    public Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest) {
        int totalAmount =0;
        List<OrderItem> orderItemList = new ArrayList<>();


        for (BuyItem buyItem : createOrderRequest.getBuyItemList()) {
            Product product = productDao.getProductById(buyItem.getProductId());

            // 計算總價錢
            int amount = buyItem.getQuantity() * product.getPrice();
            totalAmount = totalAmount + amount ;

            // 轉換 BuyItem to OrderItem
            OrderItem orderItem = new OrderItem();
            orderItem.setProductId(buyItem.getProductId());
            orderItem.setQuantity(buyItem.getQuantity());
            orderItem.setAmount(amount);

            orderItemList.add(orderItem);

        }

        // 創建訂單
        Integer orderId = orderDao.createOrder(userId, totalAmount);

        orderDao.createOrderItems(orderId, orderItemList);

        return userId;
    }
}
