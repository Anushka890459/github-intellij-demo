package com.ecommerce.sb_ecom.service;

import com.ecommerce.sb_ecom.payload.CategoryResponse;
import com.ecommerce.sb_ecom.payload.CategoryDTO;



public interface CategoryService {
//CategoryResponse getAllCategories(Integer pageNumber,Integer pageSize );

    CategoryResponse getAllCategories(Integer pageNumber,Integer pageSize,String sortBy,String sortOrder);

    CategoryResponse getAllCategories();

    CategoryDTO createCategory(CategoryDTO categoryDTO);

    CategoryDTO deleteCategory(Long categoryId);

    CategoryDTO updateCategory(CategoryDTO categoryDTO, Long categoryId);
}
