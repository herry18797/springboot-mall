package com.herry.springbootmall.dao;

import com.herry.springbootmall.dto.ProductRequest;
import com.herry.springbootmall.model.Product;

public interface ProductDao {

   Product getProductById(Integer ProductId);
   Integer creatProduct(ProductRequest productRequest);

   void updateProduct(Integer productId,ProductRequest productRequest);

}
