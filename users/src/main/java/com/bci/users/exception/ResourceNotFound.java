package com.bci.users.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class ResourceNotFound extends  RuntimeException{
    public ResourceNotFound (String resourceName, String fileName, String fieldValue){
        super(String.format("No se encontró ninún %s con el valor %s en el campo %s",
                resourceName, fileName, fieldValue));

    }
}
