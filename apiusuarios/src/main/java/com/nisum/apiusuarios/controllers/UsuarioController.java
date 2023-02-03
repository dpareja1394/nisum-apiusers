package com.nisum.apiusuarios.controllers;


import com.nisum.apiusuarios.dto.UserRequest;
import com.nisum.apiusuarios.dto.UserResponse;
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

    @PostMapping(path = "/usuarios",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponse> crearUsuarios(@RequestBody UserRequest userRequest) {
        log.info("Ingresó a crearUsuarios");
        return new ResponseEntity<UserResponse>(UserResponse.builder().name(userRequest.getName()).build(), HttpStatus.OK);
    }

}
