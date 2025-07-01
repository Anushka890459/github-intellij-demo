package com.ecommerce.sb_ecom.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@NotBlank

    private String categoryName;

    // Default constructor
    public Category() {}

    // Getter for id
    public Long getId() {
        return id;
    }

    // Getter and Setter for categoryName
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setCategoryId(Long categoryId) {
    }
}

