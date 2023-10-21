package com.codelantern.userservice.exceptions;


import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionsHandler{

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResourceNotFoundResponse> resourceNotFound(Exception ex){
        String message = ex.getMessage();
        ResourceNotFoundResponse resourceNotFoundResponse = new ResourceNotFoundResponse();
        resourceNotFoundResponse.setResource("USER");
        resourceNotFoundResponse.setMessage(message);
        resourceNotFoundResponse.setResponseStatus(404);
        return  new ResponseEntity<>(resourceNotFoundResponse, HttpStatusCode.valueOf(404));
    }

}
