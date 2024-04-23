package org.example.adapters.controllers;

import org.example.interfaces.services.ProductService;
import org.example.mapper.AppMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/api")
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
    public @ResponseBody Integer create(@RequestBody Product product) {
        return productService.create(appMapper.productControllerToProductUseCase(product));
    }

    @GetMapping("/products")
    public @ResponseBody List<Product> findAll(){
        return productService.findAll().stream().
                map(appMapper::productUseCaseToProductController)
                .toList();
    }

    @PutMapping("/products")
    public @ResponseBody Integer update(@RequestBody Product product){
        return productService.update(appMapper.productControllerToProductUseCase(product));
    }

    @DeleteMapping("/products")
    public @ResponseBody void delete (@RequestBody Integer id) {
        productService.delete(id);
    }
}
