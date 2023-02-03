package com.nisum.apiusuarios.service;

import com.nisum.apiusuarios.domain.Telefono;
import com.nisum.apiusuarios.domain.Usuario;
import com.nisum.apiusuarios.dto.PhoneRequest;

import java.util.List;

public interface TelefonoService {

    List<Telefono> crearTelefonos(List<PhoneRequest> phonesRequest, Usuario usuario) throws Exception;

}
