package com.product.review.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class ReviewNotFoundException extends RuntimeException {

    public ReviewNotFoundException(Long reviewId) {
        super("Review not found: " + reviewId);
    }
}