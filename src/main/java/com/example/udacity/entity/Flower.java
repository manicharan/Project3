package com.example.udacity.entity;

import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Flower extends Plant{

    private String color;
    public Flower(){}


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
