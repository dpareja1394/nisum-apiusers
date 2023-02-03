package com.nisum.apiusuarios.service.mappers;

import com.nisum.apiusuarios.domain.User;
import com.nisum.apiusuarios.dto.UserRequest;
import com.nisum.apiusuarios.dto.UserResponse;

public class UserMapper {

    public static User requestToDomain(UserRequest userRequest) {
        return User
                .builder()
                .name(userRequest.getName())
                .email(userRequest.getEmail())
                .password(userRequest.getPassword())
                .build();
    }

    public static UserResponse domainToResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .created(user.getCreated())
                .isActive(user.getIsActive())
                .lastLogin(user.getLastLogin())
                .modified(user.getModified())
                .token(user.getToken())
                .build();
    }

}
