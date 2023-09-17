package com.example.springdatajpa.controllers;


import com.example.springdatajpa.models.TestModel;
import com.example.springdatajpa.repositories.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestRepository testRepository;
    @PostMapping("/save-test-data")
    public String saveTestData(@RequestBody  TestModel testModel){
        testRepository.save(testModel);
        return "Test data saved successfully";
    }
    @GetMapping("/get-test-data")
    public String getTestData(){
        testRepository.findAll();
        return "Getting test data successful";
    }


}
