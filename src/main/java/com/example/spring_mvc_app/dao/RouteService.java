package com.example.spring_mvc_app.dao;

import com.example.spring_mvc_app.models.Route;
import com.example.spring_mvc_app.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.List;

@Service
public class RouteService {
    private final RouteRepository routeRepository;
    @Autowired
    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }
    public List<Route> getAllRoutes(){
        return routeRepository.findAll();
    }
    public Route getRoute(Integer id){
        return routeRepository.findAll().stream()
                .filter(route -> route.getId()==id).findAny().orElse(null);
    }
    public Route saveRoute(Route route){
        return routeRepository.save(route);
    }
    public Route editRoute(Integer id, Route route){
        Route existRoute = routeRepository.findById(id).orElse(null);
        existRoute.setDepartureTime(Time.valueOf("12:10:00"));
        existRoute.setPlaceArrival("Barcelona");
        existRoute.setPlaceDeparture("Madrid");
        existRoute.setTimeInTrip(Time.valueOf("5:00:00"));
        return routeRepository.save(route);
    }
    public void deleteRoute(Integer id){
        routeRepository.deleteById(id);
    }
}
