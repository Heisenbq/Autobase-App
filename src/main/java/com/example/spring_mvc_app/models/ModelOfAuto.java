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

    @Override
    public String toString() {
        return "ModelOfAuto{" +
                "id=" + id +
                ", maxSpeed=" + maxSpeed +
                ", weight=" + weight +
                ", height=" + height +
                ", width=" + width +
                ", model='" + model + '\'' +
                '}';
    }

    @Column
    private String model;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(Integer maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
