package com.herovired.Library.Management.System.models;


import jakarta.persistence.*;

@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String username;
    private String password;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id",referencedColumnName = "id")
    private Address address;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
