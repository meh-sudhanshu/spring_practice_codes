package com.example.springdevclass01;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary

public class Physician implements  Doctor{

    Physician(){
        System.out.println("Inside physician constructor");
    }
    @Override
    public String getAdvice() {
        return "Physician advice";
    }
}
