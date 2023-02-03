package com.nisum.apiusuarios.service;

import com.nisum.apiusuarios.domain.Phone;
import com.nisum.apiusuarios.domain.User;
import com.nisum.apiusuarios.dto.PhoneRequest;

import java.util.List;

public interface PhoneService {

    List<Phone> createPhones(List<PhoneRequest> phonesRequest, User user) throws Exception;

}
