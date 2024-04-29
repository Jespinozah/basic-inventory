package org.example.mapper;
import org.example.adapters.controllers.ProductController;
import org.example.adapters.dtos.RestDTOs;
import org.example.entities.Product;
import org.example.usecases.ProductUseCase;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AppMapper {
    ProductUseCase.Product productControllerToProductUseCase(RestDTOs.Product product);

    Product productUseCaseToProductEntity(ProductUseCase.Product product);

    ProductUseCase.Product productEntityToProductUseCase(Product product);

    RestDTOs.Product productUseCaseToProductController(ProductUseCase.Product product);

}