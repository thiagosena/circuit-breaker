package com.thiagosena.product.domain;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    void save(Product product);

    Optional<Product> getOne(Long id);

    List<Product> getAll();
}
