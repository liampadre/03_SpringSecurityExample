package com.example03.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example03.model.ProductEntity;

public interface ProductEntityRepository extends JpaRepository<ProductEntity, Long> {

    List<ProductEntity> findByName(String name);
}
