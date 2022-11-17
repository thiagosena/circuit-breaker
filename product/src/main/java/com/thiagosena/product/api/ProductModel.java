package com.thiagosena.product.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.thiagosena.product.domain.Product;
import com.thiagosena.product.infra.client.ReviewModel;

import java.util.List;

public class ProductModel {
    private final Long id;
    private final String name;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<ReviewModel> reviews;

    public ProductModel(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public ProductModel(Long id, String name, List<ReviewModel> reviews) {
        this.id = id;
        this.name = name;
        this.reviews = reviews;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    static ProductModel of(Product product) {
        return new ProductModel(
                product.getId(),
                product.getName()
        );
    }

    static ProductModel of(Product product, List<ReviewModel> reviews) {
        return new ProductModel(
                product.getId(),
                product.getName(),
                reviews
        );
    }

}
