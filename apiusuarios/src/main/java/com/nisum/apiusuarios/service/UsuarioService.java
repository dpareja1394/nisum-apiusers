package com.nisum.apiusuarios.service;

import com.nisum.apiusuarios.dto.UserRequest;
import com.nisum.apiusuarios.dto.UserResponse;

import java.util.List;

public interface UsuarioService {

    UserResponse crearUsuario(UserRequest userRequest) throws Exception;

    List<UserResponse> listarUsuarios();

}
