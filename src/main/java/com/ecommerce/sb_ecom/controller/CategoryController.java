package com.ecommerce.sb_ecom.controller;

import com.ecommerce.sb_ecom.model.Category;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("api/public")
public class CategoryController {

@GetMapping("categories")
public List<Category> getAllCategories(){
    return categories;
}
@PostMapping("categories")
public String createCategory(@RequestBody Category category){
    categories.add(category);
    return "Category added succesfully";
}
}
