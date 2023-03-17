package com.herry.springbootmall.service.impl;

import com.herry.springbootmall.dao.ProductDao;
import com.herry.springbootmall.dto.ProductRequest;
import com.herry.springbootmall.model.Product;
import com.herry.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class productServiceImpl implements ProductService {

    @Autowired
     private ProductDao productDao;




    @Override
    public Product getProductById(Integer ProductId) {

        return productDao.getProductById(ProductId);
    }

    @Override
    public Integer createProduct(ProductRequest productRequest) {
        return productDao.creatProduct(productRequest);
    }

    @Override
    public void updateProduct(Integer productId, ProductRequest productRequest) {

        productDao.updateProduct(productId,productRequest);
    }
}
