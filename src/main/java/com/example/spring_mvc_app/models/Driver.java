package com.example.spring_mvc_app.models;

import jakarta.persistence.*;

@Entity
@Table(name = "drivers")
public class Driver {
    @Id
    @Column(name = "driverID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String firstname;
    @Column
    private String surname;
    @Column
    private Integer experience;
    @Column
    private String phone;

    public Driver(Integer id, String firstname, String surname, Integer experience, String phone) {
        this.id = id;
        this.firstname = firstname;
        this.surname = surname;
        this.experience = experience;
        this.phone = phone;
    }
    public Driver() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", surname='" + surname + '\'' +
                ", experience=" + experience +
                ", phone='" + phone + '\'' +
                '}';
    }
}
