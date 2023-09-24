package com.herovired.Library.Management.System.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CategoryIdNotFoundException extends RuntimeException{
    public CategoryIdNotFoundException(String message) {
        super(message);
    }
}
