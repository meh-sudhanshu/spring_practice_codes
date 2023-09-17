package com.example.springdevclass01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class DoctorController {


    private Doctor myDoctor1;

    private Doctor myDoctor2;
    DoctorController(@Qualifier("dentist") Doctor myDoctor1 , @Qualifier("dentist")Doctor myDoctor2){
        this.myDoctor1 = myDoctor1;
        this.myDoctor2 = myDoctor2;
        System.out.println("inside doctor controller constructor");
    }


    @GetMapping("/get-advice")
    public String getDoctorAdvice(){
        return  myDoctor1.getAdvice();
    }

    @GetMapping("/check-bean-scope")
    public boolean checkBeanScope(){
        return  myDoctor1 == myDoctor2;
    }





//    private Dentist myDentist;
//
//    DoctorController(Dentist dentist){
//        this.myDentist = dentist;
//    }
////    @Value("${dentist.advice}")
////    private String dentistAdvice;
////
////    @Value("${general.advice}")
////    private String generalAdvice;
//    @GetMapping("/get-dentist-advice")
//    public String getDoctorAdvice(){
//        return myDentist.getMedicine();
//    }
////    @GetMapping("/")
////    public  String getGeneralDoctorAdvice(){
////        return generalAdvice;
////    }
}
