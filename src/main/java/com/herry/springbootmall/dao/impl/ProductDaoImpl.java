package com.herry.springbootmall.dao.impl;

import ch.qos.logback.core.model.INamedModel;
import com.herry.springbootmall.dao.ProductDao;
import com.herry.springbootmall.dto.ProductRequest;
import com.herry.springbootmall.model.Product;
import com.herry.springbootmall.rowmapper.ProductRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.plaf.basic.BasicTableUI;
import javax.swing.plaf.basic.BasicTreeUI;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;



    @Override
    public Product getProductById(Integer productId) {
        String sql="SELECT product_id,product_name, category, image_url, price, stock, description, " +
                "created_date, last_modified_date " +
                "FROM product WHERE product_id=product_id";
        Map<String,Object> map=new HashMap<>();
        map.put("productId", productId);

        List<Product> productList = namedParameterJdbcTemplate.query(sql, map, new ProductRowMapper());
        if (productList.size()>0){
         return productList.get(0);
        }else{

        return null;

        }

    }

    @Override
    public Integer creatProduct(ProductRequest productRequest) {

        String sql ="INSERT INTO product(product_name,category,image_url,price,stork,"+
                "description,created_date,last_modified_date"+
                "VALUES(:productName,:category,:imageUrl,:price,:stock,:description,"+
                ":createdDate,:lastModifiedDate";

        Map<String,Object>map=new HashMap<>();
        map.put("productName",productRequest.getProduct_name());
        map.put("category",productRequest.getCategory());
        map.put("imageUrl",productRequest.getImage_url());
        map.put("price",productRequest.getPrice());
        map.put("stock",productRequest.getStock());
        map.put("description",productRequest.getDescription());

        Date now=new Date();
        map.put("createdDate",now);
        map.put("lastModifiedDate",now);

        KeyHolder keyHolder=new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(sql,new MapSqlParameterSource(map),keyHolder);

        int productId=keyHolder.getKey().intValue();
        return productId;

    }
}
