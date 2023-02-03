package com.nisum.apiusuarios.mappers;

import com.nisum.apiusuarios.domain.User;
import com.nisum.apiusuarios.dto.UserRequest;

public class UserMapper {

    public static User requestToDomain(UserRequest userRequest) {
        return User
                .builder()
                .name(userRequest.getName())
                .email(userRequest.getEmail())
                .password(userRequest.getPassword())
                .build();
    }

}
