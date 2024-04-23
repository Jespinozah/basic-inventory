package org.example.adapters.controllers;

import org.example.interfaces.services.ProductService;
import org.example.mapper.AppMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProductController {

    public record Product(Integer id, String name, Boolean presentationInBox, Integer quantity){}

    private ProductService productService;

    private AppMapper appMapper;

    @Autowired
    public ProductController(ProductService productService, AppMapper appMapper) {
        this.productService = productService;
        this.appMapper = appMapper;
    }

    @PostMapping("/products")
    public @ResponseBody Integer createProduct(@RequestBody Product product) {
        return productService.create(appMapper.toProductUseCase(product));
    }
}
