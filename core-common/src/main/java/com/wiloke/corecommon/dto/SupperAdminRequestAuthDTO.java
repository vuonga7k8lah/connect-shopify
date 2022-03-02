package com.wiloke.corecommon.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SupperAdminRequestAuthDTO {
    private String shopName;
    private String offlineToken;
    private String email;
    private String secretPassword;
}
