package com.herovired.Library.Management.System.controllers;

import com.herovired.Library.Management.System.Authentication.UserAuthenticationObject;
import com.herovired.Library.Management.System.Authentication.UserLoginRequestObject;
import com.herovired.Library.Management.System.models.User;
import com.herovired.Library.Management.System.models.UserData;
import com.herovired.Library.Management.System.repositories.UserDataRepository;
import com.herovired.Library.Management.System.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDataRepository userDataRepository;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @GetMapping("/login")
    public UserAuthenticationObject attemptLogin(@RequestBody UserLoginRequestObject userLoginRequestObject){
            var username = userLoginRequestObject.getUsername();
            var userObject = userRepository.findByUserName(username);
            var userAuthenticationObject = new UserAuthenticationObject();
            if(userObject == null){
                userAuthenticationObject.setUsername(userAuthenticationObject.getUsername());
                userAuthenticationObject.setPassword(null);
                userAuthenticationObject.setMessage("username does not exists in the DB");
                userAuthenticationObject.setAuthenticated(false);
            }else {
                var dbPassword = userObject.getUserPassword();
                var requestPassword = userLoginRequestObject.getPassword();

                if (!Objects.equals(dbPassword, requestPassword)) {
                    userAuthenticationObject.setUsername(userAuthenticationObject.getUsername());
                    userAuthenticationObject.setPassword(requestPassword);
                    userAuthenticationObject.setMessage("password does not match");
                    userAuthenticationObject.setAuthenticated(false);
                } else {
                    userAuthenticationObject.setUsername(userAuthenticationObject.getUsername());
                    userAuthenticationObject.setPassword(requestPassword);
                    userAuthenticationObject.setMessage("User is Authenticated");
                    userAuthenticationObject.setAuthenticated(true);
                }
            }
            return  userAuthenticationObject;
    }

    @GetMapping("/fetch-user-data-with-username/{username}")
    public ResponseEntity<?> getUserData(@PathVariable String username){
        var userData = userDataRepository.findByUsername(username);

        if(userData == null){
            return new ResponseEntity<>("username does not exists", HttpStatus.ACCEPTED);
        }
       return new ResponseEntity<>(userData,HttpStatus.ACCEPTED);
    }

}
