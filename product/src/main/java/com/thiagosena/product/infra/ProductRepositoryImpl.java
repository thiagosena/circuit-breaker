package com.thiagosena.product.infra;

import com.thiagosena.product.domain.Product;
import com.thiagosena.product.domain.ProductRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProductRepositoryImpl implements ProductRepository {

    private static final List<Product> products = new ArrayList<>();
    private static long id = 1;

    private static Long nextId() {
        return id++;
    }

    static {
        products.add(new Product(nextId(), "Desktop 4GB"));
        products.add(new Product(nextId(), "iPhone 256GB"));
        products.add(new Product(nextId(), "MacBook White"));
    }

    @Override
    public void save(Product product) {
        product.setId(nextId());
        products.add(product);
    }

    @Override
    public Optional<Product> getOne(Long id) {
        return products.stream().filter(product -> product.getId().equals(id)).findFirst();
    }

    @Override
    public List<Product> getAll() {
        return new ArrayList<>(products);
    }
}
