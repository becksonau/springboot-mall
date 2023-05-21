package com.becksonsee.springbootmall.dao.impl;

import com.becksonsee.springbootmall.dao.OrderDao;
import com.becksonsee.springbootmall.model.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class OrderDaoImpl implements OrderDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public void createOrderItems(Integer orderId, List<OrderItem> orderItemList) {

        /*

        // 使用 for loop 一條一條 sql 加入數據，效率較低
        for(OrderItem orderItem : orderItemList) {

            String sql = "INSERT INTO order_item(user_id, product_id, quantity, amount)" +
                    "VALUES (:userId, :productId, :quantity, :amount)" ;

            Map<String, Object> map = new HashMap<>();
            map.put("orderId", orderId);
            map.put("productId", orderItem.getProductId());
            map.put("quantity", orderItem.getQuantity());
            map.put("amount", orderItem.getAmount());

            namedParameterJdbcTemplate.update(sql, map);
        }
        */


        // 使用 bathUpdate 一次性加入數據，效率更高， 5-5
        String sql = "INSERT INTO order_item(user_id, product_id, quantity, amount)" +
                "VALUES (:userId, :productId, :quantity, :amount)" ;

        MapSqlParameterSource[] parameterSources = new MapSqlParameterSource[orderItemList.size()];

    }

    @Override
    public Integer createOrder(Integer userId, Integer totalAmount) {
        String sql = "INSERT INTO `order`(user_id, total_amount, created_date, last_modified_date)" +
                "VALUES (:userId, :totalAmount, :createdDate, :lastModifiedDate)" ;

        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("totalAmount", totalAmount);

        Date now = new Date();
        map.put("createdDate", now);
        map.put("lastModifiedDate", now);

        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);

        int orderId = keyHolder.getKey().intValue();

        return userId;


    }
}