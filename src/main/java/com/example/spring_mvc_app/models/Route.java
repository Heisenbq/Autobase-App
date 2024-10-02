package com.example.spring_mvc_app.models;

import jakarta.persistence.*;

import java.sql.Time;

@Entity
@Table(name = "routes")
public class Route {
    @Id
    @Column(name = "routeId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "place_departure")
    private String placeDeparture;
    @Column(name = "place_arrival")
    private String placeArrival;
    @Column(name = "departure_time")
    private Time departureTime;
    @Column(name="time_in_trip")
    private Time timeInTrip;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlaceDeparture() {
        return placeDeparture;
    }

    public void setPlaceDeparture(String placeDeparture) {
        this.placeDeparture = placeDeparture;
    }

    public String getPlaceArrival() {
        return placeArrival;
    }

    public void setPlaceArrival(String placeArrival) {
        this.placeArrival = placeArrival;
    }

    public Time getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Time departureTime) {
        this.departureTime = departureTime;
    }

    public Time getTimeInTrip() {
        return timeInTrip;
    }

    public void setTimeInTrip(Time timeInTrip) {
        this.timeInTrip = timeInTrip;
    }
}
