package com.thiagosena.review.domain;

public class Review {
    private Long id;
    private final Integer grade;
    private final String description;
    private final String raterName;
    private final Long productId;

    public Review(Long id, Integer grade, String description, String raterName, Long productId) {
        this.id = id;
        this.grade = grade;
        this.description = description;
        this.raterName = raterName;
        this.productId = productId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getGrade() {
        return grade;
    }

    public String getDescription() {
        return description;
    }

    public String getRaterName() {
        return raterName;
    }

    public Long getProductId() {
        return productId;
    }
}
