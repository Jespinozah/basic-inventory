package org.example.mapper;

import org.example.adapters.dtos.RestDTOs;
import org.example.entities.Product;
import org.example.usecases.ProductUseCase;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AppMapper {
    ProductUseCase.Product productControllerToProductUseCase(RestDTOs.Product product);

    @Mapping(target = "unitsPerBox", source = "unitsPerBox", defaultValue = "0")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "id", source = "id")
    ProductUseCase.Product productEntityToProductUseCase(Product product);

    @Mapping(target = "unitsPerBox", source = "unitsPerBox", defaultValue = "0")
    RestDTOs.Product productUseCaseToProductController(ProductUseCase.Product product);

}