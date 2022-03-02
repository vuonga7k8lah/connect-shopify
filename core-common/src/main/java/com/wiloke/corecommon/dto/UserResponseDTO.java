package com.wiloke.corecommon.dto;

import com.wiloke.corecommon.entities.RoleEntity;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
public class UserResponseDTO {

    private Long id;

    private String username;

    private String name;

    private String password;

    private boolean status;

    private String email;

    private Long shopId;

    private String shopName;

    private List<RoleEntity> roles = new ArrayList<>();
}
