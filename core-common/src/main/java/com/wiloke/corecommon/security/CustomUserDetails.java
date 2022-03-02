package com.wiloke.corecommon.security;

import com.wiloke.corecommon.dto.UserResponseDTO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class CustomUserDetails implements UserDetails {

    private UserResponseDTO userResponseDTO;

    public CustomUserDetails(UserResponseDTO userResponseDTO){
        userResponseDTO = userResponseDTO;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public String getPassword() {
        return userResponseDTO.getPassword();
    }

    @Override
    public String getUsername() {
        return userResponseDTO.getUsername();
    }

    public String getDisplayName() {
        return userResponseDTO.getName();
    }

    public Long getId() {
        return userResponseDTO.getId();
    }

    public String getEmail() {
        return userResponseDTO.getEmail();
    }

    public List<String> getRoles() {

        return new ArrayList<>();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

