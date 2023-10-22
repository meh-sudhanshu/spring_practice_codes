package com.codelantern.userservice.models;

import lombok.*;

import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Booking {
    private long id;
    private String bookingId;

    private String validFrom;

    private String validTo;

    private long bookingAmount;

}
