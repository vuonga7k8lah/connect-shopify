package com.wiloke.corecommon.dto;

import com.wiloke.corecommon.entities.RoleEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PublicUserDTO {
    private Long id;

    private String username;

    private String name;

    private String profileUrl;

    private List<RoleEntity> roles;
}
