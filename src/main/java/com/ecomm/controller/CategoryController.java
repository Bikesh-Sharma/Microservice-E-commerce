package com.ecomm.controller;

import com.ecomm.dto.CategoryRequestDto;
import com.ecomm.dto.CategoryResponseDto;
import com.ecomm.dto.ExtendedCategoryResponseDto;
import com.ecomm.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;


    @PostMapping
    public CategoryResponseDto createCategory(@RequestBody CategoryRequestDto categoryRequestDto){
        CategoryResponseDto createCategory = categoryService.createCategory(categoryRequestDto);
        return createCategory;
    }

    @GetMapping
    public List<ExtendedCategoryResponseDto> getAllCategory(){
        List<ExtendedCategoryResponseDto> allCategory = categoryService.getAllCategory();
        return allCategory;
    }

    @GetMapping("/{categoryId}")
    public ExtendedCategoryResponseDto getCategoryById(@PathVariable String categoryId){
        return categoryService.getCategoryById(categoryId);
    }
}
