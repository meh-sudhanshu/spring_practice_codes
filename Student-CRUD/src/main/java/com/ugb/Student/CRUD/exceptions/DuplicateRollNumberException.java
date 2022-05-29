package com.ugb.Student.CRUD.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DuplicateRollNumberException extends RuntimeException{

    public DuplicateRollNumberException(String message) {
        super(message);
    }
}
