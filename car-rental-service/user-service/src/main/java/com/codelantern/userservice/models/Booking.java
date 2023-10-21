package com.codelantern.userservice.models;

import java.util.Date;

public class Booking {
    private long id;
    private String bookingId;

    private Date validFrom;

    private Date validTo;

    private long bookingAmount;

    private String userId;

    public Booking() {
    }

    public Booking(long id, String bookingId, Date validFrom, Date validTo, long bookingAmount, String userId) {
        this.id = id;
        this.bookingId = bookingId;
        this.validFrom = validFrom;
        this.validTo = validTo;
        this.bookingAmount = bookingAmount;
        this.userId = userId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public Date getValidTo() {
        return validTo;
    }

    public void setValidTo(Date validTo) {
        this.validTo = validTo;
    }

    public long getBookingAmount() {
        return bookingAmount;
    }

    public void setBookingAmount(long bookingAmount) {
        this.bookingAmount = bookingAmount;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
