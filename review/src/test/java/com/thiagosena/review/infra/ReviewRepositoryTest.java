package com.thiagosena.review.infra;

import com.thiagosena.review.domain.Review;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReviewRepositoryTest {

    private final ReviewRepositoryImpl repository = new ReviewRepositoryImpl();

    @Test
    void getAllReviews() {
        List<Review> reviews = repository.getAll();
        assertEquals(5, reviews.size());
        assertEquals(10, reviews.get(0).getGrade());
        assertEquals("James", reviews.get(0).getDescription());
        assertEquals("Product exceeded my expectations.", reviews.get(0).getRaterName());
        assertEquals(1, reviews.get(0).getProductId());
    }

    @Test
    void getOne() {
        var reviewId = 1L;
        Review review = repository.getOne(reviewId).orElse(null);
        assert review != null;
        assertEquals(10, review.getGrade());
        assertEquals("James", review.getDescription());
        assertEquals("Product exceeded my expectations.", review.getRaterName());
        assertEquals(1, review.getProductId());
    }

    @Test
    void saveReview() {
        var reviewId = 6L;
        Review review = new Review(null, 10, "John Doe",
                "Rater Name", 1L);

        repository.save(review);

        Review reviewFromDatabase = repository.getOne(reviewId).orElse(null);
        assert reviewFromDatabase != null;
        assertEquals(10, reviewFromDatabase.getGrade());
        assertEquals("John Doe", reviewFromDatabase.getDescription());
        assertEquals("Rater Name", reviewFromDatabase.getRaterName());
        assertEquals(1, reviewFromDatabase.getProductId());
    }
}
