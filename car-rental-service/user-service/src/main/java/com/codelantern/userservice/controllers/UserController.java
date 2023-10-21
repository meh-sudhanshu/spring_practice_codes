package com.codelantern.userservice.controllers;


import com.codelantern.userservice.exceptions.ResourceNotFoundException;
import com.codelantern.userservice.models.Booking;
import com.codelantern.userservice.models.User;
import com.codelantern.userservice.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody User user, BindingResult result){
        return userService.register(user,result);
    }

    @GetMapping("/get-all-booking/{userId}")
    public List<Booking> getAllBookings(@PathVariable String userId){
        return userService.getAllBookings(userId);
    }

    @GetMapping("/get-account-balance/{userId}")
    public ResponseEntity<?> getAccountBalance(@PathVariable String userId) throws ResourceNotFoundException {
        return userService.getAccountBalance(userId);
    }


    @GetMapping("/get-due-amount/{userId}")
    public int getDueAmount(@PathVariable String userId){
        return userService.getDueAmount(userId);
    }

}
