package com.tms.ECommerce.service;

import com.tms.ECommerce.dto.ProductDTO;
import com.tms.ECommerce.entity.Category;
import com.tms.ECommerce.entity.Product;
import com.tms.ECommerce.mapper.ProductMapper;
import com.tms.ECommerce.repository.CetegoryRepository;
import com.tms.ECommerce.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService {
    private CetegoryRepository cetegoryRepository;
    private ProductRepository productRepository;
    public ProductDTO getProductCreateService(ProductDTO productDTO){
        Category categoryId = cetegoryRepository.findById(productDTO.getCategoryId()).orElseThrow(()->new RuntimeException("Category not found"));
        Product product = ProductMapper.toProductEntity(productDTO, categoryId);
        product = productRepository.save(product);
        return ProductMapper.toProductDTO(product);


    }

    public ProductDTO updateProductService(Long id, ProductDTO productDTO){
        Product product = productRepository.findById(id).orElseThrow(()->new RuntimeException("Product not found"));
        Category category = cetegoryRepository.findById(productDTO.getCategoryId()).orElseThrow(()->new RuntimeException("Category not found"));

        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setCategory(category);

        productRepository.save(product);

        return ProductMapper.toProductDTO(product);



    }
}
