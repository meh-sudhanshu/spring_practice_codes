package com.example.peopleportal.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class People {

    @Id
    private String id;
    private String name;
    private int age;
    private String height;

    @Transient
    BankingDetails bankingDetails;




}
