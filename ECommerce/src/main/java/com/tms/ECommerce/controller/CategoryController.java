package com.tms.ECommerce.controller;


import com.tms.ECommerce.dto.CategoryDTO;
import com.tms.ECommerce.entity.Category;
import com.tms.ECommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    //create
    @PostMapping("/createCategory")
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO){
        return new ResponseEntity<>(categoryService.createCategory(categoryDTO), HttpStatus.CREATED);

    }
    @GetMapping("/findAllCategory")
    public List<CategoryDTO> fetchCategory(){
    return categoryService.getCategoryService();
    }

    @GetMapping("/find/{id}")
    public CategoryDTO fetchByCategoryId(@PathVariable Long id){
        return categoryService.fetchByCategoryIdService(id);
    }

    @DeleteMapping("/del/{id}")
    public String delCategoryById(@PathVariable Long id){
        return categoryService.deleteCategoryById(id);
    }
}
