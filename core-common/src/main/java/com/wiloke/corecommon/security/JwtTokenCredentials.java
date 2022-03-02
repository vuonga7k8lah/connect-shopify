package com.wiloke.corecommon.security;

import com.wiloke.corecommon.dto.JwtCredentialsDTO;
import io.jsonwebtoken.Claims;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import java.util.LinkedHashMap;

@Getter
@Setter
public class JwtTokenCredentials {
    private static JwtCredentialsDTO jwtCredentialsDTO;

    public static JwtCredentialsDTO parseClaims(Claims claims) {
        var linkedHashMap = claims.get("auth", LinkedHashMap.class);
        var modelMapper = new ModelMapper();
        var jwtCredentialsDTO = modelMapper.map(linkedHashMap, JwtCredentialsDTO.class);
        return jwtCredentialsDTO;
    }
}
