package com.nisum.apiusuarios.service.mappers;

import com.nisum.apiusuarios.domain.Usuario;
import com.nisum.apiusuarios.dto.UserRequest;
import com.nisum.apiusuarios.dto.UserResponse;

public class UsuarioMapper {

    public static Usuario requestToDomain(UserRequest userRequest) {
        return Usuario
                .builder()
                .name(userRequest.getName())
                .email(userRequest.getEmail())
                .password(userRequest.getPassword())
                .build();
    }

    public static UserResponse domainToResponse(Usuario usuario) {
        return UserResponse.builder()
                .id(usuario.getId())
                .name(usuario.getName())
                .email(usuario.getEmail())
                .created(usuario.getCreated())
                .isActive(usuario.getIsActive())
                .lastLogin(usuario.getLastLogin())
                .modified(usuario.getModified())
                .token(usuario.getToken())
                .build();
    }

}
