package com.nisum.apiusuarios.service;

import com.nisum.apiusuarios.dto.ErrorResponse;
import com.nisum.apiusuarios.dto.UserRequest;
import com.nisum.apiusuarios.dto.UserResponse;

public interface UserService {

    UserResponse createUser(UserRequest userRequest) throws Exception;

}
