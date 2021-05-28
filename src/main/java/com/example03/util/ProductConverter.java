package com.example03.util;

import com.example03.model.ProductEntity;
import com.example03.model.ProductRequest;
import com.example03.model.ProductResponse;

public class ProductConverter {

    public static ProductResponse convertProductEntityToProductResponse(ProductEntity productEntity) {
        return ProductResponse.builder()
                .name(productEntity.getName())
                .description(productEntity.getDescription())
                .price(productEntity.getPrice())
                .build();
    }

    public static ProductEntity convertUserRequestToUserEntity(ProductRequest productRequest) {
        return ProductEntity.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
    }
}
