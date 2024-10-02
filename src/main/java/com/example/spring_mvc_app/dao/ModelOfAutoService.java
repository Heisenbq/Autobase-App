package com.example.spring_mvc_app.dao;

import com.example.spring_mvc_app.models.ModelOfAuto;
import com.example.spring_mvc_app.repository.ModelOfAutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelOfAutoService {
    private final ModelOfAutoRepository modelOfAutoRepository;

    @Autowired
    public ModelOfAutoService(ModelOfAutoRepository modelOfAutoRepository) {
        this.modelOfAutoRepository = modelOfAutoRepository;
    }

    public List<ModelOfAuto> getAllModelsOfAutos(){
        return  modelOfAutoRepository.findAll();
    }
    public ModelOfAuto getModelOfAuto(Integer autoModelId){
        return modelOfAutoRepository.findById(autoModelId).orElse(null);
    }
    public ModelOfAuto saveModelOfAuto(ModelOfAuto modelOfAuto){
        return modelOfAutoRepository.save(modelOfAuto);
    }
    public ModelOfAuto editModelOfAuto(Integer id,ModelOfAuto modelOfAuto){
        ModelOfAuto existingModelOfAuto = modelOfAutoRepository.findById(id).orElse(null);
        existingModelOfAuto.setHeight(modelOfAuto.getHeight());
        existingModelOfAuto.setWidth(modelOfAuto.getWidth());
        existingModelOfAuto.setWeight(modelOfAuto.getWeight());
        existingModelOfAuto.setMaxSpeed(modelOfAuto.getMaxSpeed());
        existingModelOfAuto.setModel(modelOfAuto.getModel());
        return modelOfAutoRepository.save(modelOfAuto);
    }
    public void delete(Integer id){
        modelOfAutoRepository.deleteById(id);
    }
}
