package com.example.peopleportal.controllers;


import com.example.peopleportal.models.People;
import com.example.peopleportal.services.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/people")
public class PeopleController {


    @Autowired
    private PeopleService peopleService;



    @PostMapping("/save-people")
    public People savePeople(@RequestBody People people){
        return peopleService.savePeople(people);
    }


    @GetMapping("/get-all-people")
    public List<People> getAllPeoples(){
        return peopleService.getAllPeoples();
    }

    @GetMapping("/{peopleId}")
    public List<People> getSinglePeople(@PathVariable String peopleId){
        return peopleService.getAllPeoples();
    }


}
