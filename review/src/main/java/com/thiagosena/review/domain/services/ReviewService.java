package com.thiagosena.review.domain.services;

import com.thiagosena.review.api.ReviewModel;

import java.util.List;

public interface ReviewService {
    List<ReviewModel> getAllByProductId(Long productId);
}
