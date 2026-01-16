package com.ecomm.mapper;

import com.ecomm.dto.CategoryResponseDto;
import com.ecomm.entity.Category;

public class CategoryMapping {

    public static CategoryResponseDto toCategoryResponseDto(Category category){
        CategoryResponseDto categoryResponseDto = new CategoryResponseDto();
        categoryResponseDto.setCategoryId(category.getCategoryId());
        categoryResponseDto.setName(category.getName());
        categoryResponseDto.setDescription(category.getDescription());
        return categoryResponseDto;
    }

    public static Category toCategoryEntity(CategoryResponseDto categoryResponseDto){

        Category category = new Category();
        category.setCategoryId(categoryResponseDto.getCategoryId());
        category.setName(categoryResponseDto.getName());
        category.setDescription(categoryResponseDto.getDescription());
        return category;
    }
}
