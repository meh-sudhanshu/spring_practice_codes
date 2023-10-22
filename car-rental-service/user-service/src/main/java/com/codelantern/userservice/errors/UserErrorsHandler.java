package com.codelantern.userservice.errors;

import com.codelantern.userservice.models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.awt.geom.RectangularShape;
import java.util.HashMap;


@Service
public class UserErrorsHandler {
    public HashMap<String,String> validateUserObject(User user, BindingResult result){
        HashMap<String,String> errorMap = new HashMap<>();
        if(result.hasErrors()){
            for(FieldError fieldError : result.getFieldErrors()){
                errorMap.put(fieldError.getField(),fieldError.getDefaultMessage());
            }
        }
        return errorMap;
    }


    public HashMap<String,String> passwordMismatchHandler(String password){
        HashMap<String,String> errorMap = new HashMap<>();
        errorMap.put("Password","Invalid Password");
        return errorMap;
    }




}
