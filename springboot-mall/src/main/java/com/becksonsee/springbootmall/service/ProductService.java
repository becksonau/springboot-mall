package com.becksonsee.springbootmall.service;

import com.becksonsee.springbootmall.dto.ProductRequest;
import com.becksonsee.springbootmall.model.Product;

public interface ProductService {
    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest) ;
}
