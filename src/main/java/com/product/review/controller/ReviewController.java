package com.product.review.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.product.review.dto.ProductDto;
import com.product.review.entity.Product;
import com.product.review.service.ProductService;



@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{productId}/reviews")
    public List<Product> getProductReviews(@PathVariable Long productId) {
        return productService.getProductReviews(productId);
    }

//    @PostMapping("/{productId}/reviews")
//    public Product createProductReview(@PathVariable Long productId, @RequestBody ProductDto productDto) {
//        return productService.createProductReview(productId, productDto);
//    }

    @PutMapping("/{productId}/reviews")
    public Product updateProductReview(@PathVariable Long productId, @RequestBody ProductDto productDto) {
        return productService.updateProductReview(productId, productDto);
    }

    @DeleteMapping("/{productId}/reviews")
    public ResponseEntity<String> deleteProductReview(@PathVariable Long productId) {
        return productService.deleteProductReview(productId);
        //return ResponseEntity.ok("Product review deleted successfully");
    }

    
    
//    @DeleteMapping("/{productId}/reviews")
//    public ResponseEntity<String> deleteProductReview deleteProductReview(@PathVariable Long productId) {
//        productService.deleteProductReview(productId);
//    }
    
    
    @PostMapping("/{productId1}/{productId2}/compare")
    public ResponseEntity<Product> compareProducts(@PathVariable Long productId1, @PathVariable Long productId2, @RequestBody ProductDto productDto) {
           	
    	Product winningProduct = productService.compareProducts(productId1, productId2, productDto);
        return ResponseEntity.ok(winningProduct);
    }
    
    //http://localhost:8083/api/reviews/1/2/compare
//    @GetMapping("/{productId1}/{productId2}/compare")
//    public Product compareProduct(@PathVariable Long productId1, @PathVariable Long productId2, @RequestBody ProductDto productDto) {
//    	return productService.compareProducts( productId1, productId2, productDto);
//    	
//    }
}

