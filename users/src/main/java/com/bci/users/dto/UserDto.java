package com.bci.users.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;


@Data
public class UserDto {
    @NotEmpty(message = "Username is required")
    private String name;
    @NotEmpty(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;
    @NotEmpty(message = "Password is required")
    private String password;
    @NotEmpty(message = "User contact information is required")
    private List<PhoneDto> phones;



}
