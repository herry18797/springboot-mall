package com.herry.springbootmall.dto;

import com.herry.springbootmall.constant.ProductCategory;
import jakarta.annotation.Nonnull;
import org.springframework.lang.NonNull;


public class ProductRequest {

    @NonNull
    private String product_name;

    @NonNull
    private ProductCategory category;

    @NonNull
    private  String image_url;

    @NonNull
    private  Integer price;

    @NonNull
    private Integer stock;

    private String description;

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
