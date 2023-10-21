package com.codelantern.userservice.exceptions;

public class ResourceNotFoundResponse {


    private int statusCode;

    private String resource;

    private String message;

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public int getResponseStatus() {
        return statusCode;
    }

    public void setResponseStatus(int statusCode) {
        this.statusCode = statusCode;
    }
}
