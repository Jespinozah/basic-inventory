package org.example.usecases;

import org.example.interfaces.repositories.ProductRepository;
import org.example.interfaces.services.ProductService;
import org.example.mapper.AppMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductUseCase implements ProductService {


    public record Product(Integer id, String name, Boolean presentationInbox, Integer unitsPerBox) {
    }
    private final ProductRepository productRepository;

    private AppMapper mapper;

    @Autowired
    public ProductUseCase(ProductRepository productRepository, AppMapper mapper) {
        this.productRepository = productRepository;
        this.mapper = mapper;
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
    public Integer create(Product product) {
        return productRepository.save(mapper.toProductEntity(product)).getId();
    }

    @Override
    public void delete() {

    }

    @Override
    public Product update() {
        return null;
    }

}
