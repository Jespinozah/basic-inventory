package org.example.mapper;
import org.example.adapters.controllers.ProductController;
import org.example.entities.Product;
import org.example.usecases.ProductUseCase;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AppMapper {
    ProductUseCase.Product toProductUseCase(ProductController.Product product);

    Product toProductEntity(ProductUseCase.Product product);

}