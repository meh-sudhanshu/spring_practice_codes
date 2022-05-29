package com.ugb.BookCRUD.controllers;


import com.ugb.BookCRUD.models.Book;
import com.ugb.BookCRUD.repositories.BookRepository;
import com.ugb.BookCRUD.services.BookService;
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
@RequestMapping("/api/book")
@CrossOrigin
public class BookController {
    @Autowired
    private BookService bookService;





    @PostMapping("/save")
    public ResponseEntity<?> saveOrUpdate(@Valid @RequestBody Book book , BindingResult result){

        if(result.hasErrors()){
            Map<String,String> error = new HashMap<String ,String>();

            for(FieldError errors : result.getFieldErrors()){
                error.put(errors.getField(),errors.getDefaultMessage());
            }

            return new ResponseEntity<Map<String,String>>(error,HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(bookService.save(book), HttpStatus.CREATED);
    }


}
