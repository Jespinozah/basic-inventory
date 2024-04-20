package org.example.usecases;

import org.example.interfaces.repositories.ProductRepository;
import org.example.interfaces.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductUseCase implements ProductService {

    public record Product(Integer id, String name, Integer quantity) {
    }
    private final ProductRepository productRepository;

    @Autowired
    public ProductUseCase(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public Product findById(Integer id) {
        return null;
    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public Integer create() {
        return null;
    }

    @Override
    public void delete() {

    }

    @Override
    public Product update() {
        return null;
    }

}
