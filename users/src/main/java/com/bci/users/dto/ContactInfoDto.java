package com.bci.users.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import java.util.List;
import java.util.Map;


@Setter
@Getter
@ConfigurationProperties(prefix = "contact")
public class ContactInfoDto {
    private String message;
    private Map<String, String> details;
    private List<String> phoneNumbers;
}