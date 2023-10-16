package com.example.bankingportal.controller;


import com.example.bankingportal.models.BankingDetails;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bank")
public class BankDetailsController {


    @GetMapping("/get-banking-details")
    public ResponseEntity<?> getBankingDetails(){
        BankingDetails bankingDetails = new BankingDetails();
        bankingDetails.setBankName("punjab national bank");
        bankingDetails.setAccountNumber("4535000100129475");
        bankingDetails.setAccountBalance("1000");
        return  new ResponseEntity<>(bankingDetails, HttpStatusCode.valueOf(200));
    }

    



}
