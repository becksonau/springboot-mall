package com.becksonsee.springbootmall.dao;

import com.becksonsee.springbootmall.model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);
}
