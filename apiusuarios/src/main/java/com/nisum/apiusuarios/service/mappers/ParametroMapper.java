package com.nisum.apiusuarios.service.mappers;

import com.nisum.apiusuarios.domain.Parametro;
import com.nisum.apiusuarios.dto.UpdateParamRequest;

public class ParametroMapper {

    public static Parametro updateRequestToDomain(UpdateParamRequest updateParamRequest) {
        Parametro parametro = new Parametro();
        parametro.setId(updateParamRequest.getId());
        parametro.setValor(updateParamRequest.getNewValue());
        return parametro;
    }

}
