package com.example03.util;

import java.util.stream.Collectors;

import com.example03.model.UserEntity;
import com.example03.model.UserRequest;
import com.example03.model.UserResponse;

public class UserConverter {

    public static UserResponse convertUserEntityToUserResponse(UserEntity userEntity) {
        return UserResponse.builder()
                .username(userEntity.getUsername())
                .avatar(userEntity.getAvatar())
                .roles(userEntity.getAuthorities().stream().map(ga -> ga.getAuthority()).collect(Collectors.toSet()))
                .build();
    }

    public static UserEntity convertUserRequestToUserEntity(UserRequest userRequest) {
        return UserEntity.builder()
                .username(userRequest.getUsername())
                .avatar(userRequest.getAvatar())
                .password(userRequest.getPassword())
                .build();
    }
}
