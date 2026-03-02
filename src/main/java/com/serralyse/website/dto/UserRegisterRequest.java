package com.serralyse.website.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRegisterRequest {
    @NotBlank(message = "Name cannot be empty!")
    private String firstName;

    @NotBlank(message = "Last name cannot be empty!")
    private String lastName;

    @Email(message = "Please enter a valid email")
    @NotBlank(message = "e-mail cannot be empty")
    private String email;

    @NotBlank
    @Size(min = 6, message = "At least 6 characters.")
    private String password;

}
