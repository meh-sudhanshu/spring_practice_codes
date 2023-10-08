package com.herovired.Library.Management.System.controllers;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manager")
public class Manager {

    @GetMapping("/test-manager")
    public String testingManager(){
        return "Manager is tested";
    }

}
