package com.codelantern.userservice.services;

import com.codelantern.userservice.exceptions.ResourceNotFoundException;
import com.codelantern.userservice.models.Booking;
import com.codelantern.userservice.models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import java.util.List;

public interface UserService {

    List<Booking> getAllBookings(String userId);

    ResponseEntity<?> getAccountBalance(String userId) throws ResourceNotFoundException;

    int getDueAmount(String userId);


    ResponseEntity<?> register(User user, BindingResult result);

    User findByUsername(String username);

}
