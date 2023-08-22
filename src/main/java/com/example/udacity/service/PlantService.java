package com.example.udacity.service;

import com.example.udacity.entity.Plant;
import com.example.udacity.repository.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PlantService {
    @Autowired
    PlantRepository plantRepository;
    public Plant getPlantByName(String name){
        return new Plant();
    }
    public Long save(Plant plant){
        return plantRepository.save(plant).getId();
    }
    public Boolean isPlantDelivered(Long id){
        return plantRepository.isPlantDelivered(id);
    }
    public List<Plant> getPlantsCheaper(BigDecimal price){
        return plantRepository.findPlants(price);
    }
}
