package com.example.spring_mvc_app.models;

import jakarta.persistence.*;

@Entity
@Table(name = "model_of_auto")
public class ModelOfAuto {
    @Id
    @Column(name = "autoModelId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "maxspeed")
    private Integer maxSpeed;
    @Column
    private Integer weight;
    @Column
    private Integer height;
    @Column
    private Integer width;
    @Column
    private String model;
}
