package com.nisum.apiusuarios.service.impl;

import com.nisum.apiusuarios.domain.User;
import com.nisum.apiusuarios.dto.UserRequest;
import com.nisum.apiusuarios.dto.UserResponse;
import com.nisum.apiusuarios.repository.UserRepository;
import com.nisum.apiusuarios.service.UserService;
import com.nisum.apiusuarios.service.mappers.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;

    }


    @Override
    public UserResponse createUser(UserRequest userRequest) {

        Instant instantNow = Instant.now();

        User user = UserMapper.requestToDomain(userRequest);
        user.setCreated(instantNow);
        user.setModified(instantNow);
        user.setLastLogin(instantNow);
        user.setIsActive(true);

        return UserMapper.domainToResponse(userRepository.save(user));
    }
}
