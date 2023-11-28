package com.product.review.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.product.review.dto.ProductDto;
import com.product.review.entity.Product;
import com.product.review.exception.ProductNotFoundException;
import com.product.review.exception.ReviewNotFoundException;
import com.product.review.repository.ProductRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;



@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


//ADMIN PART
    
    public ResponseEntity<String> addProduct(@Valid ProductDto productDto) {
   
            Product product = new Product();
            
            
            if (productDto.getName() instanceof String && 
            	productDto.getDescription() instanceof String &&
            	productDto.getFeedback() instanceof String && 
            	productDto.getRate() instanceof String && 
            	productDto.getCategory() instanceof String && 
            	productDto.getRating() instanceof Integer)
            {
                product.setName(productDto.getName());
                product.setDescription(productDto.getDescription());
                product.setFeedback(productDto.getFeedback());
                product.setRate(productDto.getRate());
                product.setCategory(productDto.getCategory());
                
                if(productDto.getRating()> 5) {
                    return ResponseEntity.status(HttpStatus.CREATED).body("Rating cannot be greater than 5");
                }
                product.setRating(productDto.getRating());
                productRepository.save(product);
                return ResponseEntity.status(HttpStatus.CREATED).body("Product Added successfully");
                	
            }
            else 
            {
                return ResponseEntity.status(HttpStatus.CREATED).body("Invalid Inputs");

            }

    }

    public Product getProduct(Long productId) {
    	
    	
        return productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException(productId));
    }
    

    public ResponseEntity<String> deleteProduct(Long productId) {
        Optional<Product> productOptional = productRepository.findById(productId);

        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            productRepository.delete(product);
            
            return ResponseEntity.status(HttpStatus.CREATED).body("Product deleted successfully");

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }
    }
    
  
    public ResponseEntity<String> deleteProductReview(Long productId) {
        Optional<Product> productOptional = productRepository.findById(productId);

        if (productOptional.isPresent()) {
            Product review = productOptional.get();
            review.setRating(null);
            review.setFeedback(null);

            productRepository.save(review);

            return ResponseEntity.ok("Product review deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product review not found");
        }
    }

        
    
    
    public List<Product> getProductsByCategory(String category) {
        return productRepository.findByCategory(category);
    }
    
    
    
    public List<Product> getProductReviews(Long productId) {
        return productRepository.findByProductId(productId);
    }
    
    @Transactional
    public Product updateProductReview(Long productId, ProductDto productDto) {
    	Product review = productRepository.findById(productId).orElseThrow(() -> new ReviewNotFoundException(productId));
        review.setRating(productDto.getRating());
        review.setFeedback(productDto.getFeedback());
       
        return productRepository.save(review);
    }


    public Product compareProducts(Long productId1, Long productId2, ProductDto productDto) {
        //Product product1 = productRepository.findById(productId1).orElseThrow(() -> new ProductNotFoundException(productId1));
        //Product product2 = productRepository.findById(productId2).orElseThrow(() -> new ProductNotFoundException(productId2));

        	Optional<Product> r1 = 	productRepository.findById(productId1);
        	Optional<Product> r2 = 	productRepository.findById(productId2);

        	
        	Product rating1 = r1.get();
        	Product rating2 = r2.get();
        	
        	if (rating1.getRating() != null && rating2.getRating() != null) {
        	    if (rating1.getRating() > rating2.getRating()) {
        	        return rating1;
        	    } else {
        	        return rating2;
        	    }
        	} else {
        	 
        	    throw new IllegalStateException("Rating is null for at least one product");
        	}
        	

    }

    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    
    
}

