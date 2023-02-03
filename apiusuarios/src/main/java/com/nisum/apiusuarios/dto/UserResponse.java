package com.nisum.apiusuarios.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class UserResponse {
    private String id;
    private Instant created;
    private Instant modified;

    @JsonProperty("last_login")
    private Instant lastLogin;
    private String token;
    private Boolean isActive;
}
