package com.nisum.apiusuarios.service.mappers;

import com.nisum.apiusuarios.domain.Telefono;
import com.nisum.apiusuarios.dto.PhoneRequest;
import com.nisum.apiusuarios.dto.PhoneResponse;

import java.util.List;

public class TelefonoMapper {

    public static Telefono requestToDomain(PhoneRequest phoneRequest) {
        return Telefono
                .builder()
                .cityCode(phoneRequest.getCitycode())
                .countryCode(phoneRequest.getCountrycode())
                .number(phoneRequest.getNumber())
                .build();
    }

    public static List<Telefono> requestToDomainList(List<PhoneRequest> phoneRequests) {
        return phoneRequests.stream().map(p-> requestToDomain(p)).toList();
    }

    public static PhoneResponse domainToResponse(Telefono telefono) {
        return PhoneResponse
                .builder()
                .id(telefono.getId())
                .number(telefono.getNumber())
                .citycode(telefono.getCityCode())
                .countrycode(telefono.getCountryCode())
                .build();
    }

    public static List<PhoneResponse> domainToResponseList(List<Telefono> telefonos) {
        return telefonos.stream().map(t->domainToResponse(t)).toList();
    }

}
