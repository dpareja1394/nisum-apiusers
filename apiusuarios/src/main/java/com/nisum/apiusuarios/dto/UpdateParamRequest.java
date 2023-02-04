package com.nisum.apiusuarios.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateParamRequest {

    private String id;
    private String newValue;

}
