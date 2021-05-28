package com.example03.service;

import java.util.List;
import java.util.Optional;

import com.example03.model.UserEntity;
import com.example03.model.UserResponse;

public interface UserEntityService {

    Optional<UserEntity> findByUsername(String username);

    Optional<UserEntity> findById(Long id);

    UserResponse saveUser(UserEntity userEntity);

    List<UserResponse> getUsers();
}
