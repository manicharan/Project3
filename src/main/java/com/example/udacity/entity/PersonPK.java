package com.example.udacity.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;
@Embeddable
public class PersonPK implements Serializable {
    private int height;
    private String color;

    @Override
    public int hashCode() {
        return Objects.hash(height,color);
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj) return true;
        if(obj==null || this.getClass()!=obj.getClass()) return false;
        PersonPK pk = (PersonPK) obj;
        return pk.height==height && color.equals(pk.color);
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
