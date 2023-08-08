package com.example.udacity.service;

import com.example.udacity.entity.Delivery;
import com.example.udacity.entity.RecipientAndPrice;
import com.example.udacity.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryService {
    @Autowired
    DeliveryRepository deliveryRepository;
    public Long save(Delivery delivery) {
        delivery.getPlants().forEach(plant -> plant.setDelivery(delivery));
        deliveryRepository.persist(delivery);
        return delivery.getId();
    }

    public List<Delivery> getDeliveries(String name) {
        return deliveryRepository.getDeliveriesByName(name);
    }
    public Delivery getDeliveryById(Long id){
        return deliveryRepository.getDeliveryById(id);
    }
    public RecipientAndPrice getBill(Long id){
        return deliveryRepository.getRecipientAndPrice(id);
    }
}
