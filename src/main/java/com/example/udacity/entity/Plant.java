package com.example.udacity.entity;

import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Plant {
    @Id
    @GeneratedValue
    private Long id;
    @JsonView(Views.Public.class)
    @Column(precision=12,scale = 4)
    private BigDecimal price;
    @JsonView(Views.Public.class)
    @Nationalized
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)//many plants can belong to one delivery
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;
    public Plant(){}

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
