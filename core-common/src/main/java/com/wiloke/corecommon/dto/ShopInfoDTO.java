package com.wiloke.corecommon.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class ShopInfoDTO {
    @NotBlank(message = "The access token is required!")
    private String offlineToken;

    @NotBlank(message = "The shop name is required!")
    private String shopName;

    @NotBlank(message = "The shop email is required!")
    private String email;
    private Long userId;
    private String phone;
    private String name;
}
