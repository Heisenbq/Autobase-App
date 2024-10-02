package com.example.spring_mvc_app.controllers;

import com.example.spring_mvc_app.dao.RouteService;
import com.example.spring_mvc_app.models.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/routes")
public class RouteController {
    private final RouteService routeService;
    @Autowired
    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping()
    public @ResponseBody List<Route> showAll(Model model){
//        model.addAttribute("route",routeService.getAllRoutes());
//        return "autobase/routes/showRoute";
        return routeService.getAllRoutes();
    }
    @GetMapping("/{id}")
    public Route showById(@PathVariable Integer id){
        return routeService.getRoute(id);
    }
    @PostMapping()
    public @ResponseBody Route createRoute(@RequestBody Route route) {
        return routeService.saveRoute(route);
    }
    @PatchMapping("/{id}")
    public @ResponseBody Route editRoute(@RequestBody Route route,@PathVariable Integer id){
        return routeService.editRoute(id,route);
    }
    @DeleteMapping("/{id}")
    public void deleteRoute(@PathVariable Integer id){
        routeService.deleteRoute(id);
    }
}
