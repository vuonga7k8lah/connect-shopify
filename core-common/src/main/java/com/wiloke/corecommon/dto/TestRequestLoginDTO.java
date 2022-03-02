package com.wiloke.corecommon.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class TestRequestLoginDTO {
    @NotBlank(message = "The user name is required")
    @Length(max = 255, message = "The username must be less than 255 character")
    private String username;

    @NotBlank(message = "The email is required")
    @Email(message = "Invalid email")
    private String email;

    @NotBlank(message = "Please enter in your password")
    private String password;
}
