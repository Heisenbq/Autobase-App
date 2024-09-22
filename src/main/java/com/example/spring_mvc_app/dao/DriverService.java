package com.example.spring_mvc_app.dao;

import com.example.spring_mvc_app.models.Driver;
import com.example.spring_mvc_app.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {
    private final DriverRepository driverRepository;

    @Autowired
    public DriverService(DriverRepository driverRepository){
        this.driverRepository=driverRepository;
    }

    public List<Driver> getAllDrivers(){
        return  driverRepository.findAll();
    }
    public Driver getDriver(Integer id){
        return driverRepository.findAll().stream().filter(driver -> driver.getId()==id).findAny().orElse(null);
    }
    public Driver saveDriver(Driver driver){
        return driverRepository.save(driver);
    }
    public Driver editDriver(Integer id,Driver driver){
        Driver existingDriver=driverRepository.findById(id).orElse(null);
        existingDriver.setFirstname(driver.getFirstname());
        existingDriver.setSurname(driver.getSurname());
        existingDriver.setExperience(driver.getExperience());
        existingDriver.setPhone(driver.getPhone());
        return driverRepository.save(driver);
    }
    public void deleteDriver(Integer id){
        driverRepository.deleteById(id);
    }

}
