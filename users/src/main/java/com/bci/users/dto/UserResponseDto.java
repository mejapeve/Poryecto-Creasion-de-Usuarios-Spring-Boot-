package com.bci.users.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class UserResponseDto {

    private String username;
    private UUID id;
    private LocalDateTime created_at;
    private LocalDateTime modified_at;
    private LocalDateTime last_login;
    private String token;
    private boolean isActive;
}
