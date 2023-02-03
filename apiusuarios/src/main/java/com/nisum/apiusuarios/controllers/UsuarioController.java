package com.nisum.apiusuarios.controllers;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class UsuarioController {

    @GetMapping("/verUsuarios")
    public String verUsuarios() {
        return "Hola usuarios";
    }

}
