package com.example.spring_mvc_app.controllers;

import com.example.spring_mvc_app.dao.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/autos")
public class AutoController {
    private AutoService autoService;

    @Autowired
    public AutoController(AutoService autoService) {
        this.autoService = autoService;
    }

    @GetMapping()
    public String showAll(Model model){
        model.addAttribute("autos",autoService.getAllAutos());
        return "autobase/showAll";
    }
}
