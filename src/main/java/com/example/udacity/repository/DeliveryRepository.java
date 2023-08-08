package com.example.udacity.repository;

import com.example.udacity.entity.Delivery;
import com.example.udacity.entity.Plant;
import com.example.udacity.entity.RecipientAndPrice;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class DeliveryRepository {

    @PersistenceContext
    EntityManager entityManager;

    public void persist(Delivery delivery){
        entityManager.persist(delivery);
    }
    public Delivery find(Long id){
        return entityManager.find(Delivery.class,id);
    }
    public Delivery merge(Delivery delivery){
        return entityManager.merge(delivery);
    }
    public void delete(Long id){
        Delivery delivery = entityManager.find(Delivery.class,id);
        entityManager.remove(delivery);
    }
    public List<Delivery> getDeliveriesByName(String name){
        TypedQuery<Delivery> query = entityManager.createNamedQuery("Delivery.ByName", Delivery.class);
        query.setParameter("name",name);
        return query.getResultList();
    }
    public Delivery getDeliveryById(Long id){
        TypedQuery<Delivery> query = entityManager.createNamedQuery("Delivery.ById", Delivery.class);
        query.setParameter("id",id);
        return query.getSingleResult();
    }
    public RecipientAndPrice getRecipientAndPrice(Long id){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<RecipientAndPrice> criteria =  cb.createQuery(RecipientAndPrice.class);
        Root<Plant> root = criteria.from(Plant.class);
        criteria.select(cb.construct(RecipientAndPrice.class,root.get("delivery").get("name"),cb.sum(root.get("price")))).where(cb.equal(root.get("delivery").get("id"),id));
        return entityManager.createQuery(criteria).getSingleResult();
    }

}
