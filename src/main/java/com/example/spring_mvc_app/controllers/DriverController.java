package com.example.spring_mvc_app.controllers;

import com.example.spring_mvc_app.dao.DriverService;
import com.example.spring_mvc_app.models.Driver;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/drivers")
public class DriverController {
    private final DriverService driverService;
    @Autowired
    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping()
    public String showAll(Model model){
        model.addAttribute("drivers",driverService.getAllDrivers());
        return "autobase/drivers/showAllDrivers";
    }
    @GetMapping("/{id}")
    public String showById(@PathVariable Integer id,Model model){
        model.addAttribute("driver",driverService.getDriver(id));
        return "autobase/drivers/showDriver";
    }
    @GetMapping("/new")
    public String create(Model model){
        model.addAttribute("driver",new Driver());
        return "autobase/drivers/newDriver";
    }
    @PostMapping()
    public String createDriver(@ModelAttribute("driver") Driver driver){
        driverService.saveDriver(driver);
        return "redirect:/drivers";
    }
    @GetMapping("/{id}/edit")
    public String edit(Model model,@PathVariable Integer id){
        model.addAttribute("driver",driverService.getDriver(id));
        return "autobase/drivers/editDriver";
    }
    @PatchMapping("/{id}")
    public String editDriver(@ModelAttribute("driver") Driver driver, @PathVariable Integer id){
        driverService.editDriver(id,driver);
        return "redirect:/drivers";
    }
    @DeleteMapping("/{id}")
    public String deleteDriver(@PathVariable Integer id){
        driverService.deleteDriver(id);
        return "redirect:/drivers";
    }
}
