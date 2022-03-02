package com.wiloke.corecommon.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class SupperAdminAddShopDTO {
    @NotEmpty(message = "The shop name is required!")
    private String shopName;

    @NotNull
    private Long userId;

    @NotEmpty(message = "The email is required!")
    private String email;

    @Length(max = 255, message = "The offline token must be less than 255 character")
    private String offlineToken;

    private String themeName;

    @NotEmpty
    private String secretPassword;
}
