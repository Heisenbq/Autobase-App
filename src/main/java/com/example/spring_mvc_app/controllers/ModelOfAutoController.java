package com.example.spring_mvc_app.controllers;

import com.example.spring_mvc_app.dao.ModelOfAutoService;
import com.example.spring_mvc_app.models.ModelOfAuto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/models")
public class ModelOfAutoController {
    ModelOfAutoService modelOfAutoService;
    @Autowired
    public ModelOfAutoController(ModelOfAutoService modelOfAutoService) {
        this.modelOfAutoService = modelOfAutoService;
    }

    @GetMapping
    public String showAll(Model model){
        model.addAttribute("models",modelOfAutoService.getAllModelsOfAutos());
        return "autobase/modelsOfAutos/showAllModels";
    }
    @GetMapping("/{id}")
    public String showById(@PathVariable Integer id, Model model){
        model.addAttribute("model",modelOfAutoService.getModelOfAuto(id));
        return "autobase/modelsOfAutos/showModel";
    }
    @GetMapping("/new")
    public String create(Model model){
        model.addAttribute("model",new ModelOfAuto());
        return "autobase/modelsOfAutos/newModel";
    }
    @PostMapping()
    public String createModelOfAuto(@ModelAttribute("modelOfAuto") ModelOfAuto modelOfAuto){
        modelOfAutoService.saveModelOfAuto(modelOfAuto);
        return "redirect:/models";
    }
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Integer id,Model model){
        ModelOfAuto modelOfAuto=modelOfAutoService.getModelOfAuto(id);
        model.addAttribute("model",modelOfAuto);
        return "autobase/modelsOfAutos/editModel";
    }
    @PatchMapping("/{id}")
    public String editModelOfAuto(@PathVariable Integer id,@ModelAttribute("modelOfAuto") ModelOfAuto modelOfAuto){
        modelOfAutoService.editModelOfAuto(id,modelOfAuto);
        return "redirect:/models";
    }
    @DeleteMapping("/{id}")
    public String deleteModelOfAuto(@PathVariable Integer id){
        modelOfAutoService.delete(id);
        return "redirect:/models";
    }
}
