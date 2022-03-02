package com.wiloke.corecommon.dto;

import lombok.Data;

// Trong response có chứa offlineToken của Shop. Thông tin nhạy cảm.
@Data
public class PrivateShopResponseDTO {
    private Long id;

    private String shopName;

    private Long userId;

    private String email;

    private String offlineToken;

    private Byte status = 1;

    private String themeName;
}
