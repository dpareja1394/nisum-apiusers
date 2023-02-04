package com.nisum.apiusuarios.controller;

import com.nisum.apiusuarios.dto.ErrorResponse;
import com.nisum.apiusuarios.dto.UpdateParamRequest;
import com.nisum.apiusuarios.repository.ParametroRepository;
import com.nisum.apiusuarios.service.ParametroService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ParametroController {

    private final ParametroService parametroService;


    public ParametroController(ParametroService parametroService) {
        this.parametroService = parametroService;
    }

    @PutMapping(path = "/params",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity modificarParametro(@RequestBody UpdateParamRequest updateParamRequest) {
        try {
            return new ResponseEntity(parametroService.modificarParametro(updateParamRequest), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(ErrorResponse
                    .builder()
                    .mensaje(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }
}
