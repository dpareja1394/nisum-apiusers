package com.nisum.apiusuarios.service.impl;

import com.nisum.apiusuarios.domain.User;
import com.nisum.apiusuarios.dto.UserRequest;
import com.nisum.apiusuarios.dto.UserResponse;
import com.nisum.apiusuarios.repository.UserRepository;
import com.nisum.apiusuarios.service.PhoneService;
import com.nisum.apiusuarios.service.UserService;
import com.nisum.apiusuarios.service.mappers.PhoneMapper;
import com.nisum.apiusuarios.service.mappers.UserMapper;
import com.nisum.apiusuarios.utility.Constant;
import com.nisum.apiusuarios.utility.Utility;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.UUID;

@Service
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PhoneService phoneService;


    public UserServiceImpl(UserRepository userRepository, PhoneService phoneService) {
        this.userRepository = userRepository;
        this.phoneService = phoneService;
    }


    @Override
    public UserResponse createUser(UserRequest userRequest) throws Exception {
        validCreateUser(userRequest);
        Instant instantNow = Instant.now();

        User user = UserMapper.requestToDomain(userRequest);
        user.setCreated(instantNow);
        user.setModified(instantNow);
        user.setLastLogin(instantNow);
        user.setIsActive(true);
        user.setToken(UUID.randomUUID().toString());

        UserResponse userResponse = UserMapper.domainToResponse(userRepository.save(user));

        userResponse.setPhones(PhoneMapper.domainToResponseList(phoneService.createPhones(userRequest.getPhones(), user)));

        return userResponse;
    }

    private void validCreateUser(UserRequest userRequest) throws Exception {
        if (!Utility.validaPattern(userRequest.getEmail(), Constant.PATTERN_EMAIL)) {
            throw new Exception("El correo no cumple con el patrón");
        }

        boolean existsByEmail = userRepository.existsByEmail(userRequest.getEmail());
        if (existsByEmail) {
            throw new Exception("El correo ya está registrado");
        }
    }


}
