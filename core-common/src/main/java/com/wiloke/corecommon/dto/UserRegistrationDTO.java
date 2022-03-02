package com.wiloke.corecommon.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

//import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class UserRegistrationDTO {
    private Long id;

    @Length(max = 255, message = "The username must be less than 255 character")
    private String username;

    @Email(message = "Invalid email")
    private String email;

    @Length(max = 255, message = "The name must be less than 255 character")
    private String name;

    @Length(max = 255, message = "The phone must be smaller than 255 character")
    private String phone;

    private Byte status = 1;

    @NotBlank(message = "Please enter in your password")
    private String password;

    @Length(max = 255, message = "The image must be smaller than 255 character")
    @URL(regexp = "(https?:\\/\\/.*\\.(?:png|jpg|jpeg))", message = "This is not an image source")
    @JsonProperty(value = "profile_url")
    private String profileUrl;
}
