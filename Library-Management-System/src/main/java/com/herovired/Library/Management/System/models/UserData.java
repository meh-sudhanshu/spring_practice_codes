package com.herovired.Library.Management.System.models;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class UserData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_name",referencedColumnName = "id")
    private String username;

    private int totalAmount;

    private long bookList;

    private boolean isBlocked = false;

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

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public long getBookList() {
        return bookList;
    }

    public void setBookList(long bookList) {
        this.bookList = bookList;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }
}
