package com.example.udacity.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(PersonKey.class)
public class Person2 {
    @Id
    private int height;
    @Id
    private String color;
    public PersonKey getId(){
        PersonKey id = new PersonKey();
        id.setHeight(height);
        id.setColor(color);
        return id;
    }
    public void setId(PersonKey id){
        this.height=id.getHeight();
        this.color=id.getColor();
    }
}
