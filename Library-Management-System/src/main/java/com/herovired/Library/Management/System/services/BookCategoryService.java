package com.herovired.Library.Management.System.services;


import com.herovired.Library.Management.System.models.BookCategory;
import com.herovired.Library.Management.System.repositories.BookCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class BookCategoryService {

    @Autowired
    private BookCategoryRepository bookCategoryRepository;

    public HashMap<String,String> validateRequestBody(BookCategory bookCategory , BindingResult resultSet){
        HashMap<String,String> errorMap = new HashMap<>();
        if(resultSet.hasErrors()){
            for(FieldError fieldError : resultSet.getFieldErrors()){
                errorMap.put(fieldError.getField() , fieldError.getDefaultMessage());
            }
        }
        return errorMap;
    }

    public List<String> getAllCategory(){
        var bookCategoryTypeList = bookCategoryRepository.findAll();
        ArrayList<String> categoryList = new ArrayList<>();
        for(BookCategory bookCategory : bookCategoryTypeList){
            var categoryType = bookCategory.getCategoryType();
            categoryList.add(categoryType);
        }
        return categoryList;
    }



}
