package com.herry.springbootmall.controller;

import com.herry.springbootmall.dto.ProductRequest;
import com.herry.springbootmall.model.Product;
import com.herry.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {


    @Autowired
    private ProductService productService;


    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> getproduct(@PathVariable Integer productId){
        Product product=productService.getProductById(productId);

        if(product !=null){

            return ResponseEntity.status(HttpStatus.OK).body(product);

        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
}

        @PostMapping("/products")
        public ResponseEntity<Product>createProduct(@RequestBody @Validated ProductRequest productRequest){

        Integer productId=productService.createProduct(productRequest);

        Product product=productService.getProductById(productId);

        return ResponseEntity.status(HttpStatus.CREATED).body(product);
        }

        @PutMapping("/product{productId}")
      public ResponseEntity<Product> upProduct(@PathVariable Integer productId,
                                               @RequestBody @Validated ProductRequest productRequest){

       //先去檢查商品是否存在
      Product product=productService.getProductById(productId);

      if(product==null){
          return ResponseEntity.status(HttpStatus.NOT_FOUND).build();



      }
      //修改商品的數據
      productService.updateProduct(productId,productRequest);

      Product updateProduct=productService.getProductById(productId);

      return ResponseEntity.status(HttpStatus.OK).body(updateProduct);
      }


}
