package com.example.peopleportal.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(){

    }

    public ResourceNotFoundException(String message){
        super(message);
    }
}
