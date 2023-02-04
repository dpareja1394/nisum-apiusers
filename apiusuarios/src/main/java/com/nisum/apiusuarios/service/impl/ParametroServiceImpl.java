package com.nisum.apiusuarios.service.impl;

import com.nisum.apiusuarios.domain.Parametro;
import com.nisum.apiusuarios.dto.UpdateParamRequest;
import com.nisum.apiusuarios.dto.UpdateParamResponse;
import com.nisum.apiusuarios.repository.ParametroRepository;
import com.nisum.apiusuarios.service.ParametroService;
import com.nisum.apiusuarios.service.mappers.ParametroMapper;
import com.nisum.apiusuarios.utility.Utility;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class ParametroServiceImpl implements ParametroService {

    private final ParametroRepository parametroRepository;

    public ParametroServiceImpl(ParametroRepository parametroRepository) {
        this.parametroRepository = parametroRepository;
    }

    @Override
    public UpdateParamResponse modificarParametro(UpdateParamRequest updateParamRequest) throws Exception {
        validarParametro(updateParamRequest);
        Parametro parametro = ParametroMapper.updateRequestToDomain(updateParamRequest);
        String oldValue = parametroRepository.findById(parametro.getId()).get().getValor();

        parametro = parametroRepository.save(parametro);

        return UpdateParamResponse.builder()
                .id(parametro.getId())
                .oldValue(oldValue)
                .newValue(parametro.getValor())
                .build();
    }

    private void validarParametro(UpdateParamRequest updateParamRequest) throws Exception {
        if(Utility.validateObjectNull(updateParamRequest)) {
            throw new Exception("Debe ingresar los datos del parámetro para modificarlo");
        }

        if(Utility.validateEmptyOrNull(updateParamRequest.getId())) {
            throw new Exception("Id del parámetro a modificar está nulo o vacío");
        }

        if(Utility.validateEmptyOrNull(updateParamRequest.getNewValue())) {
            throw new Exception("Nuevo valor del parámetro está vacío");
        }

        boolean existsById = parametroRepository.existsById(updateParamRequest.getId());
        if(!existsById) {
            throw new Exception("No existe un parámetro con el ID "+updateParamRequest.getId());
        }
    }
 }
