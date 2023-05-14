package com.becksonsee.springbootmall.dao;

import com.becksonsee.springbootmall.dto.ProductRequest;
import com.becksonsee.springbootmall.model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);
}
