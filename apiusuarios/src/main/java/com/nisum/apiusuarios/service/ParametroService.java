package com.nisum.apiusuarios.service;

import com.nisum.apiusuarios.dto.UpdateParamRequest;
import com.nisum.apiusuarios.dto.UpdateParamResponse;

public interface ParametroService {
    UpdateParamResponse modificarParametro(UpdateParamRequest updateParamRequest) throws Exception;

}
