package com.example.spring_mvc_app.models;

import jakarta.persistence.*;

@Entity
@Table(name = "autos")
public class Auto {
    @Id
    @Column(name = "autoID")
    private Integer Id;
    @Column
    private Integer capacity;
    @Column
    private Integer mileage;

    @Column(name = "automodelID")
    private Integer nameOfModel;

    public Auto(){

    }

    public Auto(int id, int capacity, int mileage, int nameOfModel) {
        this.Id = id;
        this.capacity = capacity;
        this.mileage = mileage;
        this.nameOfModel = nameOfModel;
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

    public int getNameOfModel() {
        return nameOfModel;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "id=" + Id +
                ", capacity=" + capacity +
                ", mileage=" + mileage +
                ", nameOfModel=" + nameOfModel +
                '}';
    }

    public void setNameOfModel(int nameOfModel) {
        this.nameOfModel = nameOfModel;
    }
}
