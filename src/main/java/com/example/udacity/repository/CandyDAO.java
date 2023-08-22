package com.example.udacity.repository;

import com.example.udacity.entity.CandyData;

import java.util.List;

public interface CandyDAO {
    List<CandyData> getCandyList();
    void addCandyToDelivery(Long deliveryId,Long candyId);
    List<CandyData> getCandyForDelivery(Long deliveryId);
}
