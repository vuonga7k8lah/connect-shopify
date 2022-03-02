package com.wiloke.corecommon.utils;

import com.wiloke.corecommon.dto.JwtCredentialsDTO;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

public class SecurityUtil {
    public static Boolean hasShopId(Authentication authentication) {
        List<String> roles = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority).toList();

        if (roles.contains(RoleUtil.USER_PRIVATE)) {
            JwtCredentialsDTO jwtCredentialsDTO = (JwtCredentialsDTO) authentication.getCredentials();
            return jwtCredentialsDTO.getShopId() != null;
        }

        return true;
    }
}
