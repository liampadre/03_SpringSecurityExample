package com.example03.service;

import java.util.List;

import com.example03.model.ProductEntity;
import com.example03.model.ProductResponse;

public interface ProductEntityService {

    List<ProductResponse> findAll();

    List<ProductResponse> findByName(String name);

    ProductResponse saveProduct(ProductEntity productEntity);
}
