package com.ecomm.service;

import com.ecomm.dto.CategoryRequestDto;
import com.ecomm.dto.CategoryResponseDto;
import com.ecomm.dto.ExtendedCategoryResponseDto;

import java.util.List;

public interface CategoryService {

    CategoryResponseDto createCategory(CategoryRequestDto categoryRequestDto);
    ExtendedCategoryResponseDto getCategoryById(String categoryId);
    List<ExtendedCategoryResponseDto> getAllCategory();
    CategoryResponseDto updateCategory(String categoryId,CategoryRequestDto categoryRequestDto);
    String deleteCategory(String categoryId);

}
