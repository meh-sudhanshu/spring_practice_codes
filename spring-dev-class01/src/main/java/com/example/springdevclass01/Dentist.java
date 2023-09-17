package com.example.springdevclass01;


import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Dentist implements Doctor{

    Dentist(){
        System.out.println("Inside dentist constructor");
    }

    @Override
    public String getAdvice() {
        return "Dentist advice";
    }
}
