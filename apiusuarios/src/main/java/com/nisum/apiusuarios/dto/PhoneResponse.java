package com.nisum.apiusuarios.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PhoneResponse {
    private String id;
    private String number;
    private String citycode;
    private String countrycode;
}
