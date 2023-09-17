package com.example.springdevclass01;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component

public class FraudDoctor implements Doctor{

    FraudDoctor(){
        System.out.println("Inside fraud doctor constructor");
    }
    @Override
    public String getAdvice() {
        return "Fraud doctor advice";
    }
}
