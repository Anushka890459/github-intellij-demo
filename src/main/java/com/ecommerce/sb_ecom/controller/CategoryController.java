package com.ecommerce.sb_ecom.controller;
import com.ecommerce.sb_ecom.config.AppConstants;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.ecommerce.sb_ecom.model.Category;
import com.ecommerce.sb_ecom.payload.CategoryDTO;
import com.ecommerce.sb_ecom.payload.CategoryResponse;
import com.ecommerce.sb_ecom.service.CategoryService;
import jakarta.validation.Valid;
import jakarta.annotation.PostConstruct;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;



@RestController
@RequestMapping("/api/public")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @PostConstruct
    public void init() {
        System.out.println("✅ CategoryController loaded");
    }



    @GetMapping("/echo")
    public ResponseEntity<String> echoMessage(@RequestParam(name = "message", defaultValue = "Hello World!") String message) {


        return new ResponseEntity<>("Echoed message: " + message, HttpStatus.OK);
    }




    @GetMapping("/categories")
    public  ResponseEntity<CategoryResponse> getAllCategories(
        @RequestParam(name = "pagenumber",defaultValue = AppConstants.PAGE_NUMBER,required = false) Integer pageNumber,
        @RequestParam(name = "pagesize",defaultValue = AppConstants.PAGE_SIZE,required = false) Integer pageSize,
        @RequestParam(name="sortBy",defaultValue = AppConstants.SORT_CATEGORIES_BY,required = false) String sortBy,
        @RequestParam(name="sortOrder",defaultValue = AppConstants.SORT_DIR,required = false) String sortOrder){
        CategoryResponse categoryResponse= categoryService.getAllCategories(pageNumber,pageSize,sortBy,sortOrder);
        return new ResponseEntity<>(categoryResponse,HttpStatus.OK);
    }

    @PostMapping("/categories")
    public ResponseEntity<CategoryDTO> createCategory(@Valid @RequestBody CategoryDTO categoryDTO) {
       CategoryDTO savedCategoryDTO = categoryService.createCategory(categoryDTO);
        return new ResponseEntity<>(savedCategoryDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("/admin/categories/{categoryId}")
    public ResponseEntity<CategoryDTO> deleteCategory(@PathVariable Long categoryId) {

            CategoryDTO deletedCategory = categoryService.deleteCategory(categoryId);
            return new ResponseEntity<>(deletedCategory, HttpStatus.OK);

    }
    @PutMapping("/public/categories/{categoryId}")
    public ResponseEntity<CategoryDTO> updateCategory( @Valid @RequestBody CategoryDTO categoryDTO,
                                                @PathVariable Long categoryId)

    {
        CategoryDTO savedCategoryDTO = categoryService.updateCategory(categoryDTO, categoryId);
        return new ResponseEntity<>(savedCategoryDTO,HttpStatus.OK);

         }
    }









