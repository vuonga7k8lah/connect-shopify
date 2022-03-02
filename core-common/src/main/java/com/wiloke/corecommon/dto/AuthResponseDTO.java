package com.wiloke.corecommon.dto;

import com.wiloke.corecommon.entities.RoleEntity;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.internal.util.Lists;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class AuthResponseDTO {

    private Long id;

    private String token;

    private String type = "Bearer";

    private String username;

    private String name;

    private String email;

    // Khi khach login vao, khach se chon 1 shop
    private Long shopId;

    private String shopName;

    private String shopThemeName;

    private List<RoleEntity> roles;

    public List<String> getRoles() {
        List<String> roles = null;
        if (this.roles != null) {
            roles = this.roles.stream().map(RoleEntity::getName).collect(Collectors.toList());
        }

        return roles;
    }
}
