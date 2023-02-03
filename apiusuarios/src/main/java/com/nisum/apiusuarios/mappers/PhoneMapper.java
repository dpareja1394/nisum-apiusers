package com.nisum.apiusuarios.mappers;

import com.nisum.apiusuarios.domain.Phone;
import com.nisum.apiusuarios.dto.PhoneRequest;

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
        List<Phone> phones = new ArrayList<Phone>();
        for ( PhoneRequest phoneRequest: phoneRequests) {
            phones.add(requestToDomain(phoneRequest));
        }
        return phones;
    }

}
