package org.example.adapters.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;

@Controller
public class HtmxController {

    public record Product(Integer id, String name, String presentation, Integer quantity){}

    @GetMapping(path = "/home")
    public String getHome(){
        return "home";
    }
    @GetMapping(path = "/products")
    public String getProducts(Model model){
        var product = new Product(1, "Panadol", "Caja", 23);
        model.addAttribute("products", Arrays.asList(product));
        return "products_v1";
    }

    @GetMapping(path = "/inventory")
    public String getInventory(){
        return "";
    }
}
