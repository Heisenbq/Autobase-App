package com.example.spring_mvc_app.dao;

import com.example.spring_mvc_app.models.Auto;
import com.example.spring_mvc_app.repository.AutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutoService {
    private AutoRepository autoRepository;
    @Autowired
    public AutoService(AutoRepository autoRepository) {
        this.autoRepository = autoRepository;
    }

    public List<Auto> getAllAutos(){
        return autoRepository.findAll();
    }
    public Auto getAuto(Integer id){
        return autoRepository.findAll().stream().filter(auto -> auto.getId()==id).findAny().orElse(null);
    }
    public void addAuto(){

    }
    public void editAuto(){

    }
    public void deleteAuto(){

    }
}
