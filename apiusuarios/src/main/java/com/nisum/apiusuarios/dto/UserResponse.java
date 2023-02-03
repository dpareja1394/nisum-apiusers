package com.nisum.apiusuarios.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nisum.apiusuarios.domain.Phone;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
@Builder
public class UserResponse {
    private String id;
    private String name;
    private String email;
    private Instant created;
    private Instant modified;
    @JsonProperty("last_login")
    private Instant lastLogin;
    private String token;
    private Boolean isActive;
    private List<PhoneResponse> phones;
}
