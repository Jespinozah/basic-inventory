package org.example.adapters.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HtmxController {

    @GetMapping(path = "/home")
    public String getHome(){
        return "home";
    }
}
