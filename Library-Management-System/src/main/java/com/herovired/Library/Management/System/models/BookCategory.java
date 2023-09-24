package com.herovired.Library.Management.System.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="book_category")
public class BookCategory {

    // BookCategory -> book_category

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "category_type", unique = true)
    @NotBlank
    @Size(min = 5 , max = 20 , message = "Length should be 5 to 20 in range")
    private String categoryType;


    @Column(name = "category_id" , unique = true )
    @Min(1)
    @Max(100)
    private int categoryId;

    public BookCategory() {
    }

    public BookCategory(long id, String categoryType, int categoryId) {
        this.id = id;
        this.categoryType = categoryType;
        this.categoryId = categoryId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "BookCategory{" +
                "id=" + id +
                ", categoryType='" + categoryType + '\'' +
                ", categoryId=" + categoryId +
                '}';
    }
}
