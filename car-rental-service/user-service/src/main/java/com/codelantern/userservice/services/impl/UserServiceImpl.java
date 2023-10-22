package com.codelantern.userservice.services.impl;

import com.codelantern.userservice.errors.UserErrorsHandler;
import com.codelantern.userservice.exceptions.ResourceNotFoundException;
import com.codelantern.userservice.models.Booking;
import com.codelantern.userservice.models.User;
import com.codelantern.userservice.repositories.UserRepository;
import com.codelantern.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private UserErrorsHandler userErrorsHandler;


    @Override
    public List<Booking> getAllBookings(String userId) {
        //TODO: IMPLEMENT IT LATER
        return null;
    }

    @Override
    public ResponseEntity<?> getAccountBalance(String userId) throws ResourceNotFoundException {
        var optionalUserObject = userRepository.findByUserId(userId);
        if(optionalUserObject != null){
            var accountBalance =  optionalUserObject.getAccountBalance();
            return new ResponseEntity<>(accountBalance, HttpStatusCode.valueOf(200));
        }
        throw new ResourceNotFoundException("User with userId "+userId+" does not exists in our database");
    }

    @Override
    public int getDueAmount(String userId) {
        var optionalUserObject = userRepository.findByUserId(userId);
        return  optionalUserObject.getDueAmount();
    }

    @Override
    public ResponseEntity<?> register(User user, BindingResult result) {
        var errorMap = userErrorsHandler.validateUserObject(user,result);
        if(errorMap.isEmpty()){
            String userId = UUID.randomUUID().toString();
            user.setUserId(userId);
            user.setDob(OffsetDateTime.now());
            var registeredUserObject = userRepository.save(user);
            return new ResponseEntity<>(registeredUserObject,HttpStatusCode.valueOf(200));
        }
        return new ResponseEntity<>(errorMap,HttpStatusCode.valueOf(400));
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
