package com.example.spring_mvc_app.models;

import jakarta.persistence.*;

@Entity
@Table(name = "autos")
public class Auto {
    @Id
    @Column(name = "autoID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    @Column
    private Integer capacity;
    @Column
    private Integer mileage;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "automodelid")
    private ModelOfAuto modelOfAuto;


    public Auto(){

    }

    public Auto(int capacity, int mileage, ModelOfAuto modelOfAuto) {
        this.capacity = capacity;
        this.mileage = mileage;
        this.modelOfAuto=modelOfAuto;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "Id=" + Id +
                ", capacity=" + capacity +
                ", mileage=" + mileage +
                ", modelOfAuto=" + modelOfAuto.toString() +
                '}';
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }


    public ModelOfAuto getModelOfAuto() {
        return modelOfAuto;
    }

    public void setModelOfAuto(ModelOfAuto modelOfAuto) {
        this.modelOfAuto = modelOfAuto;
    }
}
