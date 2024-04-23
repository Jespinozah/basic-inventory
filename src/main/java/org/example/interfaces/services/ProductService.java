package org.example.interfaces.services;

import org.example.entities.Product;
import org.example.usecases.ProductUseCase;

import java.util.List;

public interface ProductService {

    ProductUseCase.Product findById(Integer id);

    List<ProductUseCase.Product> findAll();

    Integer create(ProductUseCase.Product product);

    void delete(Integer id);

    Integer update(ProductUseCase.Product product);

}
