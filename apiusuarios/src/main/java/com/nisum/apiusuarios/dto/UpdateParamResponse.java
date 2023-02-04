package com.nisum.apiusuarios.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateParamResponse {

    private String id;
    private String oldValue;
    private String newValue;

}
