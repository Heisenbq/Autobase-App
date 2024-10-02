package com.example.spring_mvc_app.controllers;

import com.example.spring_mvc_app.dao.AutoService;
import com.example.spring_mvc_app.dao.ModelOfAutoService;
import com.example.spring_mvc_app.models.Auto;
import com.example.spring_mvc_app.models.Driver;
import com.example.spring_mvc_app.models.ModelOfAuto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/autos")
public class AutoController {
    private final AutoService autoService;
    private final ModelOfAutoService modelOfAutoService;

    @Autowired
    public AutoController(AutoService autoService,ModelOfAutoService modelOfAutoService) {
        this.modelOfAutoService = modelOfAutoService;
        this.autoService = autoService;
    }

    @GetMapping()
    public String showAll(Model model){
        model.addAttribute("autos",autoService.getAllAutos());
        return "autobase/autos/showAllAutos";
    }
    @GetMapping("/{id}")
    public String showById(@PathVariable Integer id,Model model){
        model.addAttribute("auto",autoService.getAuto(id));
        return "autobase/autos/showAuto";
    }
    @GetMapping("/new")
    public String create(Model model){
        model.addAttribute("auto",new Auto());

        List<ModelOfAuto> modelsOfAutos = modelOfAutoService.getAllModelsOfAutos();
        model.addAttribute("models",modelsOfAutos);
        return "autobase/autos/newAuto";
    }
    @PostMapping()
    public String createAuto(@RequestParam("capacity") Integer capacity,@RequestParam("mileage") Integer mileAge, @RequestParam("autoModelId") Integer autoModelId){
        ModelOfAuto modelOfAuto= modelOfAutoService.getModelOfAuto(autoModelId);
        Auto auto=new Auto(capacity,mileAge,modelOfAuto);
        autoService.saveAuto(auto);
        return "redirect:/autos";
    }
    @GetMapping("/{id}/edit")
    public  String edit(Model model,@PathVariable Integer id){
        model.addAttribute("auto",autoService.getAuto(id));

        List<ModelOfAuto> modelsOfAutos=modelOfAutoService.getAllModelsOfAutos();
        model.addAttribute("models",modelsOfAutos);
        return "autobase/autos/editAuto";
    }
    @PatchMapping("/{id}")
    public String editAuto(@ModelAttribute("auto") Auto auto,@PathVariable Integer id){
        autoService.editAuto(id,auto);
        return "redirect:/autos";
    }
    @DeleteMapping("/{id}")
    public String deleteAuto(@PathVariable Integer id){
        autoService.deleteAuto(id);
        return "redirect:/autos";
    }
}
