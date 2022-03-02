package com.wiloke.corecommon.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthRequestDTO {
    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

    private String shopName;
}