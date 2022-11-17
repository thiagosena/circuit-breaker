package com.thiagosena.product.api;

import com.thiagosena.product.domain.ProductRepository;
import com.thiagosena.product.infra.client.ReviewClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository repository;
    private final ReviewClient reviewClient;

    public ProductController(ProductRepository repository, ReviewClient reviewClient) {
        this.repository = repository;
        this.reviewClient = reviewClient;
    }

    @GetMapping
    public List<ProductModel> getAll() {
        return repository.getAll()
                .stream()
                .map(ProductModel::of)
                .toList();
    }

    @GetMapping("/{productId}")
    ProductModel getById(@PathVariable Long productId) {
        return repository.getOne(productId)
                .map(product -> ProductModel.of(product, reviewClient.getAllByProductId(productId)))
                .orElseThrow(ResourceNotFoundException::new);
    }
}
