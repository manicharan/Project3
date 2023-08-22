package com.example.udacity.repository;

import com.example.udacity.entity.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
@Repository
public interface PlantRepository extends JpaRepository<Plant,Long> {
    Boolean existsPlantByIdAndDeliveryIsDelivered(Long id,Boolean delivered);
    @Query("select p.delivery.isDelivered from Plant p where p.id=:id")
    Boolean isPlantDelivered(Long id);
    List<Plant> findByPriceLessThan(BigDecimal price);
    @Query("select p from Plant p where p.price<:price")
    List<Plant> findPlants(BigDecimal price);
}
