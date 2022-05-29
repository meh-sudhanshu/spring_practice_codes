package com.ugb.Student.CRUD.models;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Student {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;




    @NotBlank(message = "student name can not be blank")
    @Size(min = 5 , max = 30 , message = "name should be 5-25 in length")
    private String name;

    @NotBlank(message = "roll number can not be blank")
    @Size(min = 1 , max = 100 , message = "roll number should be between 1 to 100")
    @Column(updatable = false ,unique = true)
    private String rollNumber;


    @NotBlank(message = "section can not be blank")
    @Pattern(regexp = "A|B|C" , message = "only allowed values are A , B AND C")
    private String section;



    @NotBlank
    @Size(min = 10 , max = 100 , message = "min and max length required are 10 and 100 respectively")
    private String feedback;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
