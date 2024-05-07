package org.example.adapters.controllers;

import org.example.adapters.dtos.RestDTOs;
import org.example.interfaces.services.ProductService;
import org.example.mapper.AppMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Arrays;

@Controller
public class HtmxController {


    private AppMapper appMapper;

    private ProductService productService;

    @Autowired
    public HtmxController(AppMapper appMapper, ProductService productService) {
        this.appMapper = appMapper;
        this.productService = productService;
    }

    @GetMapping(path = "/home")
    public String getHome(){
        return "home";
    }

    @GetMapping(path = "/products")
    public String getProducts(Model model){
        var products = productService.findAll()
                .stream()
                .map(appMapper::productUseCaseToProductController)
                .toList();
        model.addAttribute("products", products);
        return "products";
    }

    @PostMapping("/products")
    public String create(@RequestBody RestDTOs.Product product) {
        productService.create(appMapper.productControllerToProductUseCase(product));
        return "redirect:/products";
    }

    @GetMapping(path = "/inventory")
    public String getInventory(Model model){
        var item = new RestDTOs.Item("Panadol", 1, 10, 5, 10);
        model.addAttribute("inventory", Arrays.asList(item));
        return "inventory";
    }
}
