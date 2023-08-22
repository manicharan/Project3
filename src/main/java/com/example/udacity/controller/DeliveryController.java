package com.example.udacity.controller;

import com.example.udacity.entity.Delivery;
import com.example.udacity.entity.RecipientAndPrice;
import com.example.udacity.entity.Views;
import com.example.udacity.service.DeliveryService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeliveryController {
    @Autowired
    DeliveryService deliveryService;
    @PostMapping("/delivery")
    public Long scheduleDelivery(@RequestBody Delivery delivery){
        return deliveryService.save(delivery);
    }
    @GetMapping("/delivery/{name}")
    @JsonView(Views.DeliveryOnly.class)
    public List<Delivery> getDeliveries(@PathVariable("name") String name){
        return deliveryService.getDeliveries(name);
    }
    @GetMapping("/deliveryid/{id}")
    public String getDelivery(@PathVariable("id") Long id){
        Delivery d = deliveryService.getDeliveryById(id);
        String s = d.getId()+ " "+d.getName();
        return s;
    }
    @GetMapping("/delivery/bill/{id}")
    public RecipientAndPrice getBill(@PathVariable("id") Long id){
        return deliveryService.getBill(id);
    }
    @JsonView(Views.DeliveryOnly.class)
    @GetMapping("/delivery/name/{id}")
    public Delivery getDeliveryById(@PathVariable("id") Long id){
        return deliveryService.getDeliveryById(id);
    }
}
