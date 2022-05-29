package com.ugb.Student.CRUD.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@RestController
public class CustomExceptionHandler {


    @ExceptionHandler
    public ResponseEntity<?> handleDuplicateRollNumberException(Exception ex , WebRequest request){
        DuplicateRollNumberResponse response = new DuplicateRollNumberResponse(ex.getMessage());


        return  new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
