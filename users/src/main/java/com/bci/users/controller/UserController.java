package com.bci.users.controller;

import com.bci.users.dto.ContactInfoDto;
import com.bci.users.dto.ErrorResponseDto;
import com.bci.users.dto.UserDto;
import com.bci.users.dto.UserResponseDto;
import com.bci.users.exception.IncorrectPattern;
import com.bci.users.service.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;



@Tag(
        name = "Controller for user service",
        description = "Endpoint for service CRUD operations"
)
@RequiredArgsConstructor
@Validated
@RestController
@RequestMapping(path = "/users", produces = {MediaType.APPLICATION_JSON_VALUE})
public class UserController {

    @NonNull
    private IUserService iUserService;
    @NonNull
    private ContactInfoDto contactInfoDto;

    @Value("${password.regexp}")
    private String  passwordPattern;

    @Value("${password.message}")
    private String messagePassword;

    @Value("${email.regexp}")
    private String emailPattern;

    @Value("${email.message}")
    private String messageEmail;



    @Operation(
            summary = "Create User",
            description = "Create a user in the system"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP status create"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP internal server error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )

    })
    @PostMapping("/create")
    public ResponseEntity<UserResponseDto> createUsers(@Valid @RequestBody UserDto userDto){


        if (!userDto.getEmail().matches(emailPattern)) {
            throw new IncorrectPattern("email",messageEmail);
        }

        if (!userDto.getPassword().matches(passwordPattern)) {
            throw new IncorrectPattern("password",messagePassword);
        }


        UserResponseDto userResponseDto = iUserService.createUser(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponseDto);
    }

    @Operation(
            summary = "Contact Info User",
            description = "View developer contact information"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP status generate"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP internal server error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )

    })
    @GetMapping("/contact-info")
    public ResponseEntity<ContactInfoDto> getContactInfo() {
        return ResponseEntity.status(HttpStatus.OK).body(contactInfoDto);
    }

}
