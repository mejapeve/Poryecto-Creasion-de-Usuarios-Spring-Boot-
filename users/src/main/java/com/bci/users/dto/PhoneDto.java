package com.bci.users.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class PhoneDto {
    @Pattern(regexp = "(^$|[0-9]{10})", message="The mobile number must be 10 digits long")
    private String number;
    @NotEmpty(message = "City code is required")
    private String citycode;
    @NotEmpty(message = "country code is required")
    private String countrycode;
}
