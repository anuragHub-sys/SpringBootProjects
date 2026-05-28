package com.tms.ECommerce.mapper;

import com.tms.ECommerce.dto.ProductDTO;
import com.tms.ECommerce.entity.Product;

public class ProductMapper {

    public static ProductDTO toProductDTO(Product product){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());
        productDTO.setPrice(product.getPrice());
        productDTO.setCategoryId(product.getCategory().getId());
        return productDTO;
    }
}
