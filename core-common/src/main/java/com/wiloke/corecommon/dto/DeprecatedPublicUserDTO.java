package com.wiloke.corecommon.dto;

import com.wiloke.corecommon.entities.RoleEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Using for public api only. It won't public sensitive information
 */
@Getter
@Setter
public class DeprecatedPublicUserDTO {
    private Long id;

    private String username;

    private String email;

    private String name;

    private String profileUrl;

    private List<RoleEntity> roles;

    private String auth;
}
