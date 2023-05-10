package com.becksonsee.springbootmall.service;

import com.becksonsee.springbootmall.model.Product;

public interface ProductService {
    Product getProductById(Integer productId);
}
