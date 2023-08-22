package com.example.udacity.entity;

import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NamedQuery(name = "Delivery.ByName",query = "select d from Delivery d where d.name=:name")
@NamedQuery(name = "Delivery.ById",query = "select d from Delivery d where d.id=:id")
@Entity
public class Delivery {
    @Id
    @GeneratedValue
    private Long id;
    @Nationalized
    @JsonView(Views.DeliveryOnly.class)
    private String name;
    @JsonView(Views.DeliveryOnly.class)
    @Column(name="address_full",length = 500)
    private String address;
    @JsonView(Views.DeliveryOnly.class)
    private LocalDateTime date;
    @Type(type="yes_no")
    private Boolean isDelivered;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "delivery",cascade = CascadeType.ALL)
    private List<Plant> plants;
    public Delivery(){}
    public Delivery(String name){
        this.name=name;
        this.isDelivered=false;
        this.plants=new ArrayList<>();
    }

    public List<Plant> getPlants() {
        return plants;
    }

    public void setPlants(List<Plant> plants) {
        this.plants = plants;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Boolean getIsDelivered() {
        return isDelivered;
    }

    public void setIsDelivered(Boolean isDelivered) {
        this.isDelivered = isDelivered;
    }
}
