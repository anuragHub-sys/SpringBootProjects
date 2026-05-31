package com.tms.ECommerce.service;


import com.tms.ECommerce.dto.CategoryDTO;
import com.tms.ECommerce.entity.Category;
import com.tms.ECommerce.exception.CategoryAlreadyExistException;
import com.tms.ECommerce.mapper.CategoryMapper;
import com.tms.ECommerce.repository.CetegoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryService {
    private CetegoryRepository cetegoryRepository;

    public CategoryDTO createCategory(CategoryDTO categoryDTO){
        Optional<Category> categoryData = cetegoryRepository.findByName(categoryDTO.getName());
        if(categoryData.isPresent()){
            throw new CategoryAlreadyExistException("Category " +categoryDTO.getName()+" already exist");
        }
        Category category = CategoryMapper.toCategoryEntity(categoryDTO);
        category = cetegoryRepository.save(category);
        return CategoryMapper.toCategoryDTO(category);
    }

    public List<CategoryDTO> getCategoryService(){
        return cetegoryRepository.findAll().stream().map(CategoryMapper::toCategoryDTO).toList();
    }

    public CategoryDTO fetchByCategoryIdService(Long id){
       Category category = cetegoryRepository.findById(id).orElseThrow(()->new RuntimeException("category not found"));
        return CategoryMapper.toCategoryDTO(category);

    }

    public String deleteCategoryById(Long id){
        cetegoryRepository.deleteById(id);
        return "Category"+id+"has been deleted";
    }
}
