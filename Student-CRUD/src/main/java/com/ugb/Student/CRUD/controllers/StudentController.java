package com.ugb.Student.CRUD.controllers;


import com.ugb.Student.CRUD.exceptions.DuplicateRollNumberException;
import com.ugb.Student.CRUD.models.Student;
import com.ugb.Student.CRUD.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/student")

public class StudentController {


    @Autowired
    private StudentService studentService;



    @PostMapping("/save")
    public ResponseEntity<?> saveOrUpdate(@Valid  @RequestBody Student student, BindingResult result){



        if(result.hasErrors()){

            Map<String,String> errorMap = new HashMap<String,String>();

            for(FieldError error : result.getFieldErrors()){
                errorMap.put(error.getField(),error.getDefaultMessage());
            }

           return new ResponseEntity<>(errorMap,HttpStatus.BAD_REQUEST);

        }

        return new ResponseEntity<>(studentService.saveOrUpdate(student),HttpStatus.CREATED);
    }

}
