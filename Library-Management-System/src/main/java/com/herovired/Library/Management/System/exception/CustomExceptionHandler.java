package com.herovired.Library.Management.System.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;

@RestController
@ControllerAdvice
public class CustomExceptionHandler {


    @ExceptionHandler
    public ResponseEntity<?> handleIdNotFoundException(Exception ex, WebRequest wb){
        var idNotFoundExceptionResponse = new IdNotFoundExceptionResponse();
        idNotFoundExceptionResponse.setExceptionMessage(ex.getMessage());
        idNotFoundExceptionResponse.setExceptionCause(ex.getCause());
        idNotFoundExceptionResponse.setFileName(ex.getStackTrace()[0].getFileName());
        idNotFoundExceptionResponse.setMethodName(ex.getStackTrace()[0].getMethodName());
        return new ResponseEntity<>(idNotFoundExceptionResponse, HttpStatus.BAD_REQUEST);
    }

//    @ExceptionHandler
//    public ResponseEntity<?> handleCategoryIdNotFoundException(Exception ex , WebRequest wb){
//        var categoryIdNotFoundException = new CategoryIdNotFoundException(ex.getMessage());
//
//        return new ResponseEntity<>(categoryIdNotFoundException,HttpStatus.BAD_REQUEST);
//    }



}
