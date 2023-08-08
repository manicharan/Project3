package com.example.udacity.controller;

import com.example.udacity.entity.Plant;
import com.example.udacity.entity.PlantDTO;
import com.example.udacity.entity.Views;
import com.example.udacity.service.PlantService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plant")
public class PlantController {
    @Autowired
    private PlantService plantService;
    public PlantController(){}
    public PlantDTO getPlantDTO(String name){
        return convertPlantToPlantDTO(plantService.getPlantByName(name));

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
