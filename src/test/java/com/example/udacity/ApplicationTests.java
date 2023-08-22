package com.example.udacity;

import com.example.udacity.entity.Delivery;
import com.example.udacity.entity.Plant;
import com.example.udacity.repository.PlantRepository;
import com.example.udacity.service.PlantService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.List;

@DataJpaTest
class ApplicationTests {
	@Autowired
	PlantRepository plantRepository;
	@Autowired
	TestEntityManager testEntityManager;

	@Test
	void testPriceLessThan() {
		Plant p = testEntityManager.persist(new Plant("foo",4.99));
		testEntityManager.persist(new Plant("boo",5.01));
		List<Plant> lessPlants = plantRepository.findByPriceLessThan(BigDecimal.valueOf(5.00));
		Assertions.assertEquals(1,lessPlants.size(),"size");
		Assertions.assertEquals(p.getId(),lessPlants.get(0).getId(),"id");
	}
	@Test
	void testIsDelivered(){
		Plant p = testEntityManager.persist(new Plant("foo",5.00));
		Delivery d = testEntityManager.persist(new Delivery("delivery1"));
		p.setDelivery(d);
		d.getPlants().add(p);
		Assertions.assertFalse(plantRepository.isPlantDelivered(p.getId()));
		d.setIsDelivered(true);
		Assertions.assertTrue(plantRepository.isPlantDelivered(p.getId()));
	}

}
