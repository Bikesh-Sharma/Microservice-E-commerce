package com.ecomm.service.impl;

import com.ecomm.dto.CategoryRequestDto;
import com.ecomm.dto.CategoryResponseDto;
import com.ecomm.dto.ExtendedCategoryResponseDto;
import com.ecomm.entity.Category;
import com.ecomm.entity.Product;
import com.ecomm.mapper.CategoryMapping;
import com.ecomm.mapper.ProductMapping;
import com.ecomm.repository.CategoryRepository;
import com.ecomm.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public CategoryResponseDto createCategory(CategoryRequestDto categoryRequestDto) {
        Category category = new Category();
        category.setName(categoryRequestDto.getName());
        category.setDescription(categoryRequestDto.getDescription());
        Category saveCategory = categoryRepository.save(category);
        CategoryResponseDto categoryResponseDto = CategoryMapping.toCategoryResponseDto(saveCategory);
        return categoryResponseDto;
    }

    @Override
    public ExtendedCategoryResponseDto getCategoryById(String categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        ExtendedCategoryResponseDto extendedCategoryResponseDto = convertToExtendCategoryResponseDto(category);
        return extendedCategoryResponseDto;
    }

    @Override
    public List<ExtendedCategoryResponseDto> getAllCategory() {
        List<Category> categoriesList = categoryRepository.findAll();
        List<ExtendedCategoryResponseDto> categoryResponseDtos = new ArrayList<>();
        for (Category category : categoriesList){
            ExtendedCategoryResponseDto categoryResponseDto = convertToExtendCategoryResponseDto(category);

            categoryResponseDtos.add(categoryResponseDto);
        }
        return categoryResponseDtos;
    }

    @Override
    public CategoryResponseDto updateCategory(String categoryId, CategoryRequestDto categoryRequestDto) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        category.setName(categoryRequestDto.getName());
        category.setDescription(categoryRequestDto.getDescription());
        Category updateCategory = categoryRepository.save(category);
        return CategoryMapping.toCategoryResponseDto(updateCategory);
    }

    @Override
    public String deleteCategory(String categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        categoryRepository.delete(category);
        return "Category" + categoryId + " deleted successfully";
    }

    private ExtendedCategoryResponseDto convertToExtendCategoryResponseDto(Category category){
        List<Product> productsList = category.getProducts();
        return new ExtendedCategoryResponseDto(category.getCategoryId(),category.getName(),category.getDescription(),
                productsList.stream().map(ProductMapping::toProductResponseDto).toList());
    }
}
