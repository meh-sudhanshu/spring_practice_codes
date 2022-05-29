package com.ugb.BookCRUD.exceptions;

public class BookIdentifierResponse {

    private String identifier;

    public BookIdentifierResponse(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
}
