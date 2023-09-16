package com.example.springdevclass01;


import org.springframework.stereotype.Component;

@Component
public class Dentist implements Doctor{

    @Override
    public String getMedicine() {
        return "This is coming is from dentist";
    }
}
