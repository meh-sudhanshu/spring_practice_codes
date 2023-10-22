package com.codelantern.userservice.controllers;


import com.codelantern.userservice.errors.UserErrorsHandler;
import com.codelantern.userservice.exceptions.ResourceNotFoundException;
import com.codelantern.userservice.models.User;
import com.codelantern.userservice.services.UserService;
import com.codelantern.userservice.utils.LoginObject;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private UserService userService;


    @Autowired
    private UserErrorsHandler userErrorsHandler;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody User user, BindingResult result){
        return userService.register(user,result);
    }


    @GetMapping("/login")
    public ResponseEntity<?> attemptLogin(@RequestBody LoginObject loginObject) throws ResourceNotFoundException {
        var username = loginObject.getUsername();
        var password = loginObject.getPassword();
        var optionalUserObject = userService.findByUsername(username);
        if(optionalUserObject == null){
            throw new ResourceNotFoundException("user with username "+username+" does not exists in our db");
        }
        if(!Objects.equals(optionalUserObject.getPassword(), password)){
            var errorMap = userErrorsHandler.passwordMismatchHandler(password);
            return new ResponseEntity<>(errorMap, HttpStatusCode.valueOf(400));
        }
        return new ResponseEntity<>(optionalUserObject,HttpStatusCode.valueOf(200));
    }

}
