package com.example.udacity.entity;

import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
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
    private String name;
    @Column(name="address_full",length = 500)
    private String address;
    private LocalDateTime date;
    @Type(type="yes_no")
    private Boolean isDelivered;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "delivery",cascade = CascadeType.ALL)
    private List<Plant> plants;
    public Delivery(){}

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
