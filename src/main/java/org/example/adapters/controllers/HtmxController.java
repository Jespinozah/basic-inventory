package org.example.adapters.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.swing.*;
import java.util.Arrays;

@Controller
public class HtmxController {

    public record Product(Integer id, String name, Boolean presentationInBox, Integer quantity){}

    public record Item (String name, Integer numberOfBoxes, Integer unitsPerBox, Integer units, Integer total){}

    @GetMapping(path = "/home")
    public String getHome(){
        return "home";
    }

    @GetMapping(path = "/products")
    public String getProducts(Model model){
        var product = new Product(1, "Panadol", true, 23);
        model.addAttribute("products", Arrays.asList(product));
        return "products";
    }

    @GetMapping(path = "/inventory")
    public String getInventory(Model model){
        var item = new Item("Panadol", 1, 10, 5, 10);
        model.addAttribute("inventory", Arrays.asList(item));
        return "inventory";
    }
}
