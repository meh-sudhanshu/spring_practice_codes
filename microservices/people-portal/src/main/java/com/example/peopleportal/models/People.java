package com.example.peopleportal.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
public class People {

    @Id
    private String id;
    private String name;
    private int age;
    private String height;

    @Transient
    BankingDetails bankingDetails;

    public People() {
    }

    public People(String id, String name, int age, String height, BankingDetails bankingDetails) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.height = height;
        this.bankingDetails = bankingDetails;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public BankingDetails getBankingDetails() {
        return bankingDetails;
    }

    public void setBankingDetails(BankingDetails bankingDetails) {
        this.bankingDetails = bankingDetails;
    }
}
