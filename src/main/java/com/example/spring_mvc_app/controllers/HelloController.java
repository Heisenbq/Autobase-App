package com.example.spring_mvc_app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/controller")
public class HelloController {
    @GetMapping
    public String sayHello(Model model, @RequestParam(value = "name",required = false) String name,
                           @RequestParam(value = "surname",required = false) String surname){
        model.addAttribute("message","Hello, "+ name + " "+ surname);
        return "hello-world";
    }
}
