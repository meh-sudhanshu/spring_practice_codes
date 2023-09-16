package com.example.springdevclass01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoctorController {

    private Dentist myDentist;

    @Autowired
    DoctorController(Dentist dentist){
        this.myDentist = dentist;
    }
//    @Value("${dentist.advice}")
//    private String dentistAdvice;
//
//    @Value("${general.advice}")
//    private String generalAdvice;
    @GetMapping("/get-dentist-advice")
    public String getDoctorAdvice(){
        return myDentist.getMedicine();
    }
//    @GetMapping("/")
//    public  String getGeneralDoctorAdvice(){
//        return generalAdvice;
//    }
}
