package com.thiagosena.review.domain.services.impl;

import com.thiagosena.review.api.ReviewModel;
import com.thiagosena.review.domain.ReviewRepository;
import com.thiagosena.review.domain.services.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository repository;

    public ReviewServiceImpl(ReviewRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ReviewModel> getAllByProductId(Long productId) {
        return repository.getAll()
                .stream()
                .filter(review -> review.getProductId().equals(productId))
                .map(ReviewModel::of)
                .toList();
    }
}
