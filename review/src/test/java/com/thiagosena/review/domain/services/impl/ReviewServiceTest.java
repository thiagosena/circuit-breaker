package com.thiagosena.review.domain.services.impl;

import com.thiagosena.review.api.ReviewModel;
import com.thiagosena.review.domain.Review;
import com.thiagosena.review.domain.ReviewRepository;
import com.thiagosena.review.domain.services.ReviewService;
import com.thiagosena.review.infra.ReviewRepositoryImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ReviewServiceTest {

    private final ReviewRepository repository = mock(ReviewRepositoryImpl.class);
    public final ReviewService service = new ReviewServiceImpl(repository);

    @Test
    void getAllByProductId() {
        var productId = 1L;
        var reviews = List.of(new Review(null, 10, "John Doe",
                "Rater Name", 1L));

        when(repository.getAll()).thenReturn(reviews);

        List<ReviewModel> review = service.getAllByProductId(productId);

        verify(repository, times(1)).getAll();
        assert review != null;
        assertEquals(1, review.size());
        assertEquals(10, review.get(0).grade());
        assertEquals("John Doe", review.get(0).description());
        assertEquals("Rater Name", review.get(0).raterName());
    }
}
