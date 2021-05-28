package com.example03.service.impl;

import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example03.model.ProductEntity;
import com.example03.model.ProductResponse;
import com.example03.repository.ProductEntityRepository;
import com.example03.service.ProductEntityService;
import com.example03.util.ProductConverter;

@Service
@RequiredArgsConstructor
public class ProductEntityServiceImpl implements ProductEntityService {

    private final ProductEntityRepository repository;

    @Override
    public List<ProductResponse> findAll() {
        return repository.findAll().stream()
                .map(ProductConverter::convertProductEntityToProductResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductResponse> findByName(String name) {
        return repository.findByName(name).stream()
                .map(ProductConverter::convertProductEntityToProductResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ProductResponse saveProduct(ProductEntity productEntity) {
        return ProductConverter.convertProductEntityToProductResponse(repository.save(productEntity));
    }
}
