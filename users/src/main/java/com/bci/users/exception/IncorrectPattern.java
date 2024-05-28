package com.bci.users.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST)
public class IncorrectPattern extends RuntimeException{

    public IncorrectPattern (String campo, String message){
        super(String.format("The %s is incorrect: %s",campo,message));
    }

}
