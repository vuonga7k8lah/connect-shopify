package com.wiloke.corecommon.security;

import com.wiloke.corecommon.constants.ErrorMessage;
import com.wiloke.corecommon.dto.JwtCredentialsDTO;
import com.wiloke.corecommon.entities.RoleEntity;
import com.wiloke.corecommon.exceptions.UnauthorisedException;
import com.wiloke.corecommon.utils.StringUtil;
import io.jsonwebtoken.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.server.ServerWebExchange;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

//@Component
public class JwtDownstreamTokenValidation {
    /**
     * THIS IS NOT A SECURE PRACTICE! For simplicity, we are storing a static key here. Ideally, in a
     * microservices environment, this key would be kept on a config-server.
     */
    private String secretKey = "erpsystem";
    private static Jws<Claims> claimsJws;
    private static String token;

    private final long validityInMilliseconds = 13104000000L; // 364 days

//    @PostConstruct
//    protected void init() {
//        this.secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
//    }

    private UserDetails rebuildCustomUserDetails(JwtCredentialsDTO jwtCredentialsDTO) {
        List<RoleEntity> roles = jwtCredentialsDTO.getRoles();
        List<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (RoleEntity role : roles) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return new User(
                String.join(
                        "-",
                        jwtCredentialsDTO.getUsername(),
                        jwtCredentialsDTO.getEmail()
                ),

                StringUtil.randomString(),
                true,
                true,
                true,
                true,
                grantedAuthorities
        );
    }

    public Authentication getAuth() {
        if (JwtDownstreamTokenValidation.claimsJws == null) {
            throw new IllegalArgumentException("Invalid Token");
        }
        var secretKeyBytes = Base64.getEncoder().encodeToString(this.secretKey.getBytes());
        var jwtCredentialsDTO = JwtTokenCredentials.parseClaims(JwtDownstreamTokenValidation.claimsJws.getBody());
        UserDetails userDetails = this.rebuildCustomUserDetails(jwtCredentialsDTO);

        var claims = Jwts.parser().setSigningKey(secretKeyBytes).parseClaimsJws(token).getBody();
        var claimParser = JwtTokenCredentials.parseClaims(claims);

        return new UsernamePasswordAuthenticationToken(
                userDetails,
                claimParser,
                userDetails.getAuthorities()
        );
    }

    public boolean validateToken(String token) {
        var secretKeyBytes = Base64.getEncoder().encodeToString(secretKey.getBytes());
        try {
            JwtDownstreamTokenValidation.claimsJws = Jwts.parser()
                    .setSigningKey(secretKeyBytes)
                    .parseClaimsJws(token);
            JwtDownstreamTokenValidation.token = token;
            return (!JwtDownstreamTokenValidation.claimsJws.getBody().getExpiration().before(new Date()));
        } catch (JwtException | IllegalArgumentException e) {
            throw new UnauthorisedException(ErrorMessage.TokenInvalid.MESSAGE, e.getMessage());
        }
    }


    public String resolveToken(HttpServletRequest req) {
        String bearerToken = req.getHeader("Authorization");

        if (bearerToken != null && bearerToken.startsWith("Bearer")) {
            return bearerToken.substring(7);
        }

        return null;
    }

    public String resolveToken(ServerWebExchange serverWebExchange) {
        String bearerToken = serverWebExchange.getRequest().getHeaders().getFirst("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer")) {
            return bearerToken.substring(7);
        }

        return null;
    }
}
