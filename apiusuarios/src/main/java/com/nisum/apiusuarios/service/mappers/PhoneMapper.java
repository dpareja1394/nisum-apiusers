package com.nisum.apiusuarios.service.mappers;

import com.nisum.apiusuarios.domain.Phone;
import com.nisum.apiusuarios.dto.PhoneRequest;
import com.nisum.apiusuarios.dto.PhoneResponse;

import java.util.ArrayList;
import java.util.List;

public class PhoneMapper {

    public static Phone requestToDomain(PhoneRequest phoneRequest) {
        return Phone
                .builder()
                .cityCode(phoneRequest.getCitycode())
                .countryCode(phoneRequest.getCountrycode())
                .number(phoneRequest.getNumber())
                .build();
    }

    public static List<Phone> requestToDomainList(List<PhoneRequest> phoneRequests) {
        return phoneRequests.stream().map(p-> requestToDomain(p)).toList();
    }

    public static PhoneResponse domainToResponse(Phone phone) {
        return PhoneResponse
                .builder()
                .id(phone.getId())
                .number(phone.getNumber())
                .citycode(phone.getCityCode())
                .countrycode(phone.getCountryCode())
                .build();
    }

    public static List<PhoneResponse> domainToResponseList(List<Phone> phones) {
        return phones.stream().map(p->domainToResponse(p)).toList();
    }

}
