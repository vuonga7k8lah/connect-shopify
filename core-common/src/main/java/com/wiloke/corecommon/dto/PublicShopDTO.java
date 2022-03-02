package com.wiloke.corecommon.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PublicShopDTO {
    private Long id;

    private String shopName;

    private Long userId;

    private String email;

//    private String offlineToken;

    private Byte status = 1;

    private String themeName;
}
