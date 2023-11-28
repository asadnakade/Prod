package com.product.review.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.review.dto.ProductDto;
import com.product.review.entity.Product;
import com.product.review.service.ProductService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/products")
public class ProductContoller {
	
	@Autowired
    private ProductService productService;
	

	
	@PostMapping("/products")
    public ResponseEntity<String> addProduct(@RequestBody ProductDto productDto) {
        return productService.addProduct(productDto);
    }
	
	
	@GetMapping("/{productId}")
    public Product getProduct(@PathVariable Long productId) {
        return productService.getProduct(productId);
    }
	
	 
	 @DeleteMapping("/{productId}/products")
	    public ResponseEntity<String> deleteProduct(@PathVariable Long productId) {
	        return productService.deleteProduct(productId);
	    }

	 @GetMapping("/bycategory/{category}")
	    public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable String category) {
	        List<Product> products = productService.getProductsByCategory(category);
	        return new ResponseEntity<>(products, HttpStatus.OK);
	    }
}
