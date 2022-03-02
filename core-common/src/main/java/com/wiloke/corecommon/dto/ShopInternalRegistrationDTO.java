package com.wiloke.corecommon.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ShopInternalRegistrationDTO {
    @NotNull(message = "The user id is required")
    private Long userId;

    @Length(max = 255, message = "The shop name must be less than 255 character")
    private String shopName;

    @Email(message = "Invalid email")
    private String email;

    @Length(max = 255, message = "The offline token must be less than 255 character")
    private String offlineToken;

    @Length(max = 255, message = "The online token must be smaller than 255 character")
    private String onlineToken;

    @Length(max = 255, message = "The theme name must be smaller than 255 character")
    private String themeName;
}
