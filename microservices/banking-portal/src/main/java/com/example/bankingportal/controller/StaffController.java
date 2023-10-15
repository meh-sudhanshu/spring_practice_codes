package com.example.bankingportal.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/staff")
public class StaffController {
    @GetMapping("/get-staff")
    public String getStaffs(){
        return "This is a staff";
    }

}


