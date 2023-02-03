package com.nisum.apiusuarios.controller;


import com.nisum.apiusuarios.dto.ErrorResponse;
import com.nisum.apiusuarios.dto.UserRequest;
import com.nisum.apiusuarios.dto.UserResponse;
import com.nisum.apiusuarios.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping(path = "/users",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity crearUsuario(@RequestBody UserRequest userRequest) {
        UserResponse userResponse = null;
        try {
            userResponse = usuarioService.crearUsuario(userRequest);
            return new ResponseEntity<>(userResponse, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(ErrorResponse.builder().mensaje(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }

    }

}
