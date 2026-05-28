package com.tms.ECommerce.service;


import com.tms.ECommerce.dto.CategoryDTO;
import com.tms.ECommerce.entity.Category;
import com.tms.ECommerce.mapper.CategoryMapper;
import com.tms.ECommerce.repository.CetegoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    CetegoryRepository cetegoryRepository;

    public CategoryDTO createCategory(CategoryDTO categoryDTO){
        Category category = CategoryMapper.toCategoryEntity(categoryDTO);
        category = cetegoryRepository.save(category);
        return CategoryMapper.toCategoryDTO(category);
    }
}
