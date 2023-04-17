package com.nisum.apiusuarios.service.impl;

import com.nisum.apiusuarios.domain.Parametro;
import com.nisum.apiusuarios.domain.Usuario;
import com.nisum.apiusuarios.dto.PhoneResponse;
import com.nisum.apiusuarios.dto.UserRequest;
import com.nisum.apiusuarios.dto.UserResponse;
import com.nisum.apiusuarios.repository.ParametroRepository;
import com.nisum.apiusuarios.repository.UsuarioRepository;
import com.nisum.apiusuarios.service.TelefonoService;
import com.nisum.apiusuarios.service.UsuarioService;
import com.nisum.apiusuarios.service.mappers.TelefonoMapper;
import com.nisum.apiusuarios.service.mappers.UsuarioMapper;
import com.nisum.apiusuarios.utility.Constant;
import com.nisum.apiusuarios.utility.Utility;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

@Service
@Transactional
@Slf4j
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository userRepository;

    private final TelefonoService telefonoService;

    private final ParametroRepository paramRepository;


    public UsuarioServiceImpl(UsuarioRepository userRepository, TelefonoService telefonoService, ParametroRepository paramRepository) {
        this.userRepository = userRepository;
        this.telefonoService = telefonoService;
        this.paramRepository = paramRepository;
    }


    @Override
    public UserResponse crearUsuario(UserRequest userRequest) throws Exception {
        validarCrearUsuario(userRequest);
        Instant instantNow = Instant.now();

        Usuario user = UsuarioMapper.requestToDomain(userRequest);
        user.setCreated(instantNow);
        user.setModified(instantNow);
        user.setLastLogin(instantNow);
        user.setIsActive(true);
        user.setToken(UUID.randomUUID().toString());

        UserResponse userResponse = UsuarioMapper.domainToResponse(userRepository.save(user));

        userResponse.setPhones(TelefonoMapper.domainToResponseList(telefonoService.crearTelefonos(userRequest.getPhones(), user)));

        return userResponse;
    }

    @Override
    public List<UserResponse> listarUsuarios() {
        return UsuarioMapper.domainToResponseList(userRepository.findAll()).stream().map(u -> {
            u.setPhones(telefonoService.consultarTelefonosPorUsuario(u.getId()));
            return u;
        }).toList();
    }

    private void validarCrearUsuario(UserRequest userRequest) throws Exception {
        if(Utility.validateEmptyOrNull(userRequest.getName())) {
            throw new Exception("Debe ingresar el nombre");
        }

        if(Utility.validateListNullOrSizeZero(userRequest.getPhones())) {
            throw new Exception("Debe ingresar al menos un teléfono");
        }

        if (!Utility.validatePattern(userRequest.getEmail(), Constant.PATTERN_EMAIL)) {
            throw new Exception("El correo no cumple con el patrón");
        }

        Parametro parametroPassword = paramRepository.findById(Constant.PASSWORD_PATTERN).get();
        if(!Utility.validatePattern(userRequest.getPassword(), parametroPassword.getValor())) {
            throw new Exception("El password no cumple con el patrón "+parametroPassword.getValor());
        }

        boolean existsByEmail = userRepository.existsByEmail(userRequest.getEmail());
        if (existsByEmail) {
            throw new Exception("El correo ya está registrado");
        }
    }


}
