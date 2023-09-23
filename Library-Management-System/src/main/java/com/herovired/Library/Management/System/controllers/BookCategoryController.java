package com.herovired.Library.Management.System.controllers;


import com.herovired.Library.Management.System.models.BookCategory;
import com.herovired.Library.Management.System.repositories.BookCategoryRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book-category")
public class BookCategoryController {

    @Autowired
    private BookCategoryRepository bookCategoryRepository;
    @PostMapping("/save")
    public ResponseEntity<?> saveBookCategory(@Valid  @RequestBody  BookCategory bookCategory , BindingResult resultSet){

        if(resultSet.hasErrors()){
            HashMap<String,String> errorMap = new HashMap<>();
            for(FieldError fieldError : resultSet.getFieldErrors()){
                errorMap.put(fieldError.getField() , fieldError.getDefaultMessage());
            }

            return  new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
        }

        var savedBookCategoryObject =  bookCategoryRepository.save(bookCategory);
        return new ResponseEntity<>(savedBookCategoryObject,HttpStatus.ACCEPTED);
    }

    @GetMapping("/get-all-categories")
    public List<BookCategory> getAllBookCategories(){
        return (List<BookCategory>) bookCategoryRepository.findAll();
    }

    @GetMapping("/get-by-id/{id}")// localhost:8080/book-category/get-by-id/
    public Optional<BookCategory> getById(@PathVariable long id){
        return bookCategoryRepository.findById(id);
    }

    @GetMapping("/get-all-category-type")
    public List<String> getAllCategoryType(){
        var bookCategoryTypeList = bookCategoryRepository.findAll();
        ArrayList<String> categoryList = new ArrayList<>();

        for(BookCategory bookCategory : bookCategoryTypeList){
            var categoryType = bookCategory.getCategoryType();
            categoryList.add(categoryType);
        }
        return categoryList;
    }

    @GetMapping("/find-by-category-type")
    public BookCategory findByCategoryType(@RequestBody  String categoryType){
        return bookCategoryRepository.findByCategoryType(categoryType);
    }

    @GetMapping("/find-by-category-id/{categoryId}")
    public  BookCategory findByCategoryId(@PathVariable int categoryId){
        return bookCategoryRepository.findByCategoryId(categoryId);
    }

}
