package com.nisum.apiusuarios.service.impl;

import com.nisum.apiusuarios.domain.Phone;
import com.nisum.apiusuarios.domain.User;
import com.nisum.apiusuarios.dto.PhoneRequest;
import com.nisum.apiusuarios.repository.PhoneRepository;
import com.nisum.apiusuarios.service.PhoneService;
import com.nisum.apiusuarios.service.mappers.PhoneMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class PhoneServiceImpl implements PhoneService {

    private final PhoneRepository phoneRepository;

    public PhoneServiceImpl(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }

    @Override
    public List<Phone> createPhones(List<PhoneRequest> phonesRequest, User user) throws Exception {
        return phoneRepository.saveAll(
                PhoneMapper.requestToDomainList(phonesRequest).stream().map(
                        p->{
                            p.setUser(user);
                            return p;
                        }
                ).collect(Collectors.toList())
        );
    }
}
