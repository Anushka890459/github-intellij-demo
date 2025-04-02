package com.ecommerce.sb_ecom.service;

import com.ecommerce.sb_ecom.model.Category;

import java.util.ArrayList;
import java.util.List;
@Service

public class CategoryServiceimpl implements CategoryService {
    private CategoryService categoryService;

    public CategoryServiceimpl(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    private List<Category> categories = new ArrayList<>();
    @Override
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @Override
    public void createCategory(Category category) {
        categoryService.createCategory(category);
        return "Category is added succesfully";
    }
}
