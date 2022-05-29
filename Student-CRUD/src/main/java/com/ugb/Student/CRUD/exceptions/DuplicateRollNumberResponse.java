package com.ugb.Student.CRUD.exceptions;

public class DuplicateRollNumberResponse {

    private String rollNumber;

    public DuplicateRollNumberResponse(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }
}
