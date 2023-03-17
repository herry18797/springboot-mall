package com.herry.springbootmall.service;

import com.herry.springbootmall.dto.ProductRequest;
import com.herry.springbootmall.model.Product;

public interface ProductService {

    Product getProductById(Integer ProductId);

    Integer createProduct(ProductRequest productRequest);


    void updateProduct(Integer productId,ProductRequest productRequest);




}
