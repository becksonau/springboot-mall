package com.becksonsee.springbootmall.service;

import com.becksonsee.springbootmall.dto.ProductQueryParams;
import com.becksonsee.springbootmall.dto.ProductRequest;
import com.becksonsee.springbootmall.model.Product;

import java.util.List;

public interface ProductService {



    List<Product> getProducts(ProductQueryParams productQueryParams) ;

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest) ;

    void deleteProductById(Integer productId);
}
