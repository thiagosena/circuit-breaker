package com.thiagosena.review.infra;

import com.thiagosena.review.domain.Review;
import com.thiagosena.review.domain.ReviewRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ReviewRepositoryImpl implements ReviewRepository {

    private static final List<Review> REVIEWS = new ArrayList<>();
    private static long id = 1;

    static {
        REVIEWS.add(new Review(nextId(), 10, "James",
                "Product exceeded my expectations.", 1L));
        REVIEWS.add(new Review(nextId(), 1, "Paul",
                "The product came wrong.", 1L));
        REVIEWS.add(new Review(nextId(), 4, "Mary",
                "Computer freezes a lot.", 1L));

        REVIEWS.add(new Review(nextId(), 8, "Denis",
                "Almost perfect.", 2L));
        REVIEWS.add(new Review(nextId(), 5, "Alex",
                "Doesn't come with an operating system.", 3L));
    }

    private static long nextId() {
        return id++;
    }

    @Override
    public void save(Review review) {
        review.setId(nextId());
        REVIEWS.add(review);
    }

    @Override
    public Optional<Review> getOne(Long id) {
        return REVIEWS.stream()
                .filter(review -> review.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Review> getAll() {
        return new ArrayList<>(REVIEWS);
    }
}
