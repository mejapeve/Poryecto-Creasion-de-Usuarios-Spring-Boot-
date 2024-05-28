package com.bci.users.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST)
public class UserAlreadyExists extends RuntimeException{
    public UserAlreadyExists (String message){
        super(message);
    }
}
