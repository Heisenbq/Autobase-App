package com.example.spring_mvc_app.repository;

import com.example.spring_mvc_app.models.ModelOfAuto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelOfAutoRepository extends JpaRepository<ModelOfAuto,Integer> {
}
