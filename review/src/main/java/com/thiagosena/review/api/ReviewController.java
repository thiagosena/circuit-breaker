package com.thiagosena.review.api;

import com.thiagosena.review.domain.services.ReviewService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService service;

    public ReviewController(ReviewService service) {
        this.service = service;
    }

    @GetMapping("/{productId}")
    List<ReviewModel> getByProduct(@PathVariable Long productId) {
        return service.getAllByProductId(productId);
    }
}
