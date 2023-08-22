package com.example.udacity.controller;

import com.example.udacity.entity.Plant;
import com.example.udacity.entity.PlantDTO;
import com.example.udacity.entity.Views;
import com.example.udacity.service.PlantService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/plant")
public class PlantController {
    @Autowired
    private PlantService plantService;
    public PlantController(){}
    public PlantDTO getPlantDTO(String name){
        return convertPlantToPlantDTO(plantService.getPlantByName(name));

    }
    @PostMapping
    public Long savePlant(@RequestBody Plant plant){
        return plantService.save(plant);
    }
    @JsonView(Views.Public.class)
    @GetMapping("/{price}")
    public List<Plant> getPlantsCheaper(@PathVariable("price") BigDecimal price){
        return plantService.getPlantsCheaper(price);
    }

    private PlantDTO convertPlantToPlantDTO(Plant plantByName) {
        PlantDTO plantDTO = new PlantDTO();
        BeanUtils.copyProperties(plantByName,plantDTO);
        return plantDTO;
    }

    @JsonView(Views.Public.class)
    public Plant getFilteredPlant(String name){
        return plantService.getPlantByName(name);
    }
}
