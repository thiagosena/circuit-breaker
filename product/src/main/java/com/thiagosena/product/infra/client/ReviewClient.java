package com.thiagosena.product.infra.client;

import com.thiagosena.product.config.CircuitBreakerLogConfig;
import feign.FeignException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collections;
import java.util.List;

@FeignClient(value = "review", url = "${clients.review.url}")
public interface ReviewClient {

    @GetMapping("/reviews/{productId}")
    @CircuitBreaker(name = "reviewCB", fallbackMethod = "getFallbackBrokenCircuit")
    List<ReviewModel> getAllByProductId(@PathVariable Long productId);

    default List<ReviewModel> getFallbackBrokenCircuit(Long productId, Throwable cause) {
        final Logger log = LoggerFactory.getLogger(CircuitBreakerLogConfig.class);

        if (cause instanceof FeignException) {
            log.error("Error when get product: {}", productId, cause);
            return List.of(new ReviewModel(null, null, null, null));
        } else {
            log.error("Circuit open", cause);
            return Collections.emptyList();
        }
    }
}
