package com.ugb.BookCRUD.models;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;




    @NotBlank(message = "Book name can not be blank")
    @Size(min = 3 , max = 100 , message = "length should be 3 to 100")
    private  String name;

    @NotBlank(message = "Identifier can not be blank")
    @Size(min= 3 , max = 10 , message ="length should be 3 to 10" )
    @Column(unique = true)
    private  String identifier;

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

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
}
