package com.nisum.apiusuarios.service.impl;

import com.nisum.apiusuarios.domain.Telefono;
import com.nisum.apiusuarios.domain.Usuario;
import com.nisum.apiusuarios.dto.PhoneRequest;
import com.nisum.apiusuarios.repository.TelefonoRepository;
import com.nisum.apiusuarios.service.TelefonoService;
import com.nisum.apiusuarios.service.mappers.TelefonoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class TelefonoServiceImpl implements TelefonoService {

    private final TelefonoRepository phoneRepository;

    public TelefonoServiceImpl(TelefonoRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }

    @Override
    public List<Telefono> crearTelefonos(List<PhoneRequest> phonesRequest, Usuario usuario) throws Exception {
        return phoneRepository.saveAll(
                TelefonoMapper.requestToDomainList(phonesRequest).stream().map(
                        p->{
                            p.setUsuario(usuario);
                            return p;
                        }
                ).collect(Collectors.toList())
        );
    }
}
