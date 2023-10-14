package com.example.peopleportal.controllers;


import com.example.peopleportal.models.BankingDetails;
import com.example.peopleportal.models.People;
import com.example.peopleportal.services.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/people")
public class PeopleController {


    @Autowired
    private PeopleService peopleService;


    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/save-people")
    public People savePeople(@RequestBody People people){
        return peopleService.savePeople(people);
    }


    @GetMapping("/get-all-people")
    public List<People> getAllPeoples(){
        return peopleService.getAllPeoples();
    }

    @GetMapping("/{peopleId}")
    public People getSinglePeople(@PathVariable String peopleId) {
        String url = "http://bank-portal/bank/get-banking-details";
        var bankingDetails = restTemplate.getForObject(url,BankingDetails.class);
        var peopleObject = peopleService.getPeopleById(peopleId);
        peopleObject.setBankingDetails(bankingDetails);
        return peopleObject;
    }
}
