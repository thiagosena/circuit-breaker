package com.thiagosena.review.api;

import com.thiagosena.review.domain.Review;

public record ReviewModel(Long id, Integer grade, String description, String raterName) {
    public static ReviewModel of(Review review) {
        return new ReviewModel(
                review.getId(),
                review.getGrade(),
                review.getDescription(),
                review.getRaterName());
    }
}
