package com.herovired.Library.Management.System.controllers;


import com.herovired.Library.Management.System.exception.IdNotFoundException;
import com.herovired.Library.Management.System.models.BookCategory;
import com.herovired.Library.Management.System.repositories.BookCategoryRepository;
import com.herovired.Library.Management.System.services.BookCategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    @Autowired
    private BookCategoryService bookCategoryService;
    @PostMapping("/save")
    public ResponseEntity<?> saveBookCategory(@Valid  @RequestBody  BookCategory bookCategory , BindingResult resultSet){

        var errorMap = bookCategoryService.validateRequestBody(bookCategory, resultSet);
        if(errorMap.size() != 0){
            return  new ResponseEntity<>(errorMap,HttpStatus.BAD_REQUEST);
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
        var optionalBookCategoryObject = bookCategoryRepository.findById(id);
        if(optionalBookCategoryObject.isEmpty()){
            throw new IdNotFoundException("id "+id+ " does not exist");
        }

        return optionalBookCategoryObject;
    }

    @GetMapping("/get-all-category-type")
    public List<String> getAllCategoryType(){
        return bookCategoryService.getAllCategory();
    }

    @GetMapping("/find-by-category-type")
    public BookCategory findByCategoryType(@RequestBody  String categoryType){
        return bookCategoryRepository.findByCategoryType(categoryType);
    }

    @GetMapping("/find-by-category-id/{categoryId}")
    public  BookCategory findByCategoryId(@PathVariable int categoryId){
        return bookCategoryRepository.findByCategoryId(categoryId);
    }

    @PostMapping("/update-book-category-object-by-id/{id}")
    public ResponseEntity<?> updateBookCategoryObjectById(@PathVariable long id){
        var bookCategoryObject = bookCategoryRepository.findById(id);
        if(bookCategoryObject.isPresent()){
            bookCategoryObject.get().setCategoryType("Science");
            bookCategoryObject.get().setCategoryId(100);
            bookCategoryObject.get().setId(id);
            System.out.println("--------------------------------------"+bookCategoryObject.get().toString());
            var updatedBookCategoryObject =  bookCategoryRepository.save(bookCategoryObject.get());

            return new ResponseEntity<>(updatedBookCategoryObject,HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("Object Does not Exist",HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/get-sorted-by-category-type")
    public List<BookCategory> getBookCategorySortedByCategoryType(@RequestParam String field){
        Sort sort = Sort.by(field);
        return bookCategoryRepository.findAll(sort.descending());
    }

    @GetMapping("/get-paged-data")
    public ArrayList<BookCategory> getPagedData(@RequestParam(defaultValue = "0") int pageIndex){
        ArrayList<BookCategory> responseList = new ArrayList<>();
        Pageable pageable = PageRequest.of(pageIndex,2);
        var pagedResponse = bookCategoryRepository.findAll(pageable);
        var pageContent = pagedResponse.getContent();
        for(BookCategory bookCategory : pageContent){
            responseList.add(bookCategory);
        }
        return responseList;
    }

}
