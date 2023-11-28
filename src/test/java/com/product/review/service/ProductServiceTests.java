package com.product.review.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.product.review.dto.ProductDto;
import com.product.review.entity.Product;
import com.product.review.repository.ProductRepository;
import com.product.review.service.ProductService;

class ProductServiceTest {

    private ProductService productService;
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        productRepository = mock(ProductRepository.class);
        productService = new ProductService();
        productService.setProductRepository(productRepository);
    }

    @Test
    void testAddProduct_ValidInput() {
        // Arrange
        ProductDto productDto = createValidProductDto();

        // Act
        ResponseEntity<String> response = productService.addProduct(productDto);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Product Added successfully", response.getBody());
        verify(productRepository, times(1)).save(any());
    }

    @Test
    void testAddProduct_InvalidInput() {
        // Arrange
        ProductDto productDto = createInvalidProductDto();

        // Act
        ResponseEntity<String> response = productService.addProduct(productDto);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Invalid Inputs", response.getBody());
        verify(productRepository, never()).save(any());
    }

    private ProductDto createValidProductDto() {
        ProductDto productDto = new ProductDto();
        productDto.setName("Sample Product");
        productDto.setDescription("Sample Description");
        productDto.setFeedback("Sample Feedback");
        productDto.setRate("Sample Rate");
        productDto.setCategory("Sample Category");
        productDto.setRating(4);
        return productDto;
    }

    private ProductDto createInvalidProductDto() {
        ProductDto productDto = new ProductDto();
        productDto.setRate("Invalid Rate");
        productDto.setCategory("Wm");
        return productDto;
    }
    
    
    
}
