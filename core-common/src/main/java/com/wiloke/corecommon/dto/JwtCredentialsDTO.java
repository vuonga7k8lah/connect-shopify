package com.wiloke.corecommon.dto;

import com.wiloke.corecommon.entities.RoleEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class JwtCredentialsDTO {
    private Long id;
    private Long userId;
    private String email;
    private String name;
    private String username;
    private Long shopId;
    private String shopName;
//    private String loginVia;
    private List<RoleEntity> roles;

    public Long getUserId() {
        return this.id;
    }
}
