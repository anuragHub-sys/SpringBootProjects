package com.tms.ECommerce.controller;


import com.tms.ECommerce.dto.ProductDTO;
import com.tms.ECommerce.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {
    private ProductService productService;

    @PostMapping
    public ResponseEntity<ProductDTO> creteProduct(@RequestBody ProductDTO productDTO){
        return new ResponseEntity<>(productService.getProductCreateService(productDTO), HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ProductDTO updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO){
        return productService.updateProductService(id,productDTO);
    }

}
