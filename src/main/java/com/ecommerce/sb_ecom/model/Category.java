package com.ecommerce.sb_ecom.model;

public class Category {
    private long categoryId;
    private String categoryName;

    public long getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }
}
